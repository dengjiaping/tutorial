/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) DomainRepositoryInterceptor.java 2014-10-30 12:32
 */

package com.nonobank.data.repository.support;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.nonobank.data.domain.AbstractEntity;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

/**
 * The domain entity's repository mapping interceptor.
 *
 * @author fuchun
 * @version $Id: DomainRepositoryInterceptor.java 310 2014-10-30 05:15:55Z fuchun $
 * @since 2.0
 */
public class DomainRepositoryInterceptor implements MethodInterceptor {

    private static final Set<String> DEFAULT_METHODS =
            ImmutableSet.of("findOne", "findAll", "findBy", "get", "list", "find");

    private final Set<String> methodStarting = new HashSet<>(16);

    public DomainRepositoryInterceptor() {
        super();
        methodStarting.addAll(DEFAULT_METHODS);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object proxy = getProxyOrTarget(invocation);
        Method method = invocation.getMethod();
        Object target = invocation.proceed();
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

    private boolean isIntercept(Method method) {
        String methodName = method.getName();
        for (String s : methodStarting) {
            if (methodName.startsWith(s)) {
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

    private Object getProxyOrTarget(MethodInvocation invocation) {
        if (invocation instanceof ProxyMethodInvocation) {
            return ((ProxyMethodInvocation) invocation).getProxy();
        }
        return invocation.getThis();
    }

    public void setMethodStarting(Collection<String> methods) {
        if (methods == null || methods.isEmpty()) {
            return;
        }
        methodStarting.addAll(methods);
    }
}
