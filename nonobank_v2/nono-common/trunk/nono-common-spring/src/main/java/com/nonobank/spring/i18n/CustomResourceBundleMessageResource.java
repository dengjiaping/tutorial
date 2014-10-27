/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CustomResourceBundleMessageResource.java 2014-10-27 16:47
 */

package com.nonobank.spring.i18n;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * The {@code ResourceBundleMessageSource} extends implementation.
 *
 * @author fuchun
 * @version $Id: CustomResourceBundleMessageResource.java 290 2014-10-27 08:48:18Z fuchun $
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
