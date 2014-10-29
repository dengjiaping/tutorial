/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserModels.java 2014-10-28 10:48
 */

package com.nonobank.user.domain.ctx;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.nonobank.user.domain.core.*;
import org.apache.commons.beanutils.PropertyUtils;

import javax.annotation.Nonnull;
import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fuchun
 * @version $Id: UserModules.java 298 2014-10-29 03:05:00Z fuchun $
 * @since 2.0
 */
public class UserModules {

    private static final UserModules INSTANCE = new UserModules();

    static {
        register(UserAccount.class);
        register(UserProfile.class);
        register(UserSocial.class);
        register(UserAuthc.class);
        register(UserOption.class);
        register(UserStats.class);
    }

    public static UserModules getInstance() {
        return INSTANCE;
    }

    @Nonnull
    public static List<Class<?>> getClasses(String propName) {
        List<Class<?>> list = new ArrayList<>();
        FIRST: for (Map.Entry<Class<?>, Collection<PropertyDescriptor>> entry :
                INSTANCE.typeToProperties.asMap().entrySet()) {
            Class<?> clazz = entry.getKey();
            Collection<PropertyDescriptor> pdList = entry.getValue();
            for (PropertyDescriptor pd : pdList) {
                if (propName.equals(pd.getName())) {
                    list.add(clazz);
                    continue FIRST;
                }
            }
        }
        return list;
    }

    @Nonnull
    public static List<String> getProperties(Class<?> clazz) {
        if (!INSTANCE.typeToProperties.containsKey(clazz)) {
            return Collections.emptyList();
        }
        return INSTANCE.typeToProperties.get(clazz).stream()
                .map(FeatureDescriptor::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public static void register(Class<?> userModelClass) {
        PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(userModelClass);
        INSTANCE.typeToProperties.putAll(userModelClass, Arrays.asList(pds).stream()
                .filter(pd -> !"new".equals(pd.getName()))
                .collect(Collectors.toList()));
    }

    private final Multimap<Class<?>, PropertyDescriptor> typeToProperties;

    UserModules() {
        this.typeToProperties = HashMultimap.create(30, 50);
    }

    public Multimap<Class<?>, PropertyDescriptor> getTypeToProperties() {
        return typeToProperties;
    }

}