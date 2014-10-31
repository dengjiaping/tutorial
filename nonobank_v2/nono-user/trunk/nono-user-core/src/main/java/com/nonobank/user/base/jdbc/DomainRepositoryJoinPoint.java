/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) DomainRepositoryJoinPoint.java 2014-10-30 14:19
 */

package com.nonobank.user.base.jdbc;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.nonobank.data.domain.AbstractEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author fuchun
 * @version $Id: DomainRepositoryJoinPoint.java 313 2014-10-30 07:55:34Z fuchun $
 * @since 2.0
 */
public class DomainRepositoryJoinPoint {

    private static final Set<String> DEFAULT_METHODS =
            ImmutableSet.of("findOne", "findAll", "findBy", "get", "list", "find");

    private final Set<String> methodStarting = new HashSet<>(16);

    public DomainRepositoryJoinPoint() {
        super();
        methodStarting.addAll(DEFAULT_METHODS);
    }

    public Object injectRepository(ProceedingJoinPoint joinPoint) throws Throwable{
        Object proxy = getProxyOrTarget(joinPoint);
        String method = joinPoint.getSignature().getName();
        Object target = joinPoint.proceed();
        if (target == null) {
            return null; // do anything
        } else if (!isIntercept(method)) {
            return target;
        }
        Class<?> targetClass = target.getClass();
        // Entity object
        if (canInjectRepository(target)) {
            injectRepository(target, proxy);
        }
        // Collection entities (List, Set ...)
        else if (Collection.class.isAssignableFrom(targetClass)) {
            ((Collection<?>) target).stream()
                    .filter(this::canInjectRepository)
                    .forEach(o -> injectRepository(o, proxy));
        }
        // Iterable implementation entities
        else if (Iterable.class.isAssignableFrom(targetClass)) {
            Iterables.filter((Iterable<?>) target, this::canInjectRepository)
                    .forEach(o -> injectRepository(o, proxy));
        }
        // Entity[] arrays
        else if (targetClass.isArray() && Array.getLength(target) > 0) {
            Arrays.asList((Object[]) target).stream()
                    .filter(this::canInjectRepository)
                    .forEach(o -> injectRepository(o, proxy));
        }
        // Map entities (only value) Map<SomeType, Entity>
        else if (Map.class.isAssignableFrom(targetClass)) {
            ((Map<?, ?>) target).forEach((k, v) -> {
                if (canInjectRepository(v)) {
                    injectRepository(v, proxy);
                }
            });
        }
        return target;
    }

    private boolean isIntercept(String method) {
        for (String s : methodStarting) {
            if (method.startsWith(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean canInjectRepository(Object component) {
        return component != null &&
                AbstractEntity.class.isAssignableFrom(
                        component instanceof Class ? (Class<?>) component :
                                component.getClass());
    }

    @SuppressWarnings("unchecked")
    private void injectRepository(Object component, Object proxy) {
        if (component == null) {
            return;
        }
        ((AbstractEntity) component).setRepository((CrudRepository) proxy);
    }

    private Object getProxyOrTarget(ProceedingJoinPoint joinPoint) {
        if (joinPoint instanceof ProxyMethodInvocation) {
            return ((ProxyMethodInvocation) joinPoint).getProxy();
        }
        return joinPoint.getThis();
    }

    public void setMethodStarting(Collection<String> methods) {
        if (methods == null || methods.isEmpty()) {
            return;
        }
        methodStarting.addAll(methods);
    }
}
