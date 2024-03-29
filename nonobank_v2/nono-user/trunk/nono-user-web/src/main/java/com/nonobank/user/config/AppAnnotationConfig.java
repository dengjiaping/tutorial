/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) AppAnnotationConfig.java 2014-10-29 16:52
 */

package com.nonobank.user.config;

import com.nonobank.spring.i18n.CustomMessageSource;
import com.nonobank.spring.i18n.MessageSources;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuchun
 * @version $Id: AppAnnotationConfig.java 306 2014-10-30 02:54:16Z fuchun $
 * @since 2.0
 */
@Configuration
public class AppAnnotationConfig implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Bean
    public MessageSources messageSources() {
        if (MessageSources.getMessageSource() == null) {
            MessageSources.getInstance().setMessageSource(
                    beanFactory.getBean("messageSource", CustomMessageSource.class)
            );
        }
        return MessageSources.getInstance();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
