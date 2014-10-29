/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) FormModel.java 2014-10-29 09:53
 */

package com.nonobank.web.annotation;

import java.lang.annotation.*;

/**
 * @author fuchun
 * @version $Id: FormModel.java 297 2014-10-29 03:03:33Z fuchun $
 * @since 2.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormModel {

    String value() default "";
}
