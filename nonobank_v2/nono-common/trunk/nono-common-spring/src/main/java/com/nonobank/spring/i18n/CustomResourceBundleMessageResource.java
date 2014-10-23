/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CustomResourceBundleMessageResource.java 2014-09-24 17:32
 */

package com.nonobank.spring.i18n;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * The {@code ResourceBundleMessageSource} extends implementation.
 *
 * @author fuchun
 * @version $Id: CustomResourceBundleMessageResource.java 27 2014-09-24 09:40:40Z fuchun $
 * @since 2.0
 */
public class CustomResourceBundleMessageResource extends ResourceBundleMessageSource
        implements CustomMessageSource {

    /**
     * Construct a new CustomResourceBundleMessageResource.
     */
    public CustomResourceBundleMessageResource() {
        super();
    }
}
