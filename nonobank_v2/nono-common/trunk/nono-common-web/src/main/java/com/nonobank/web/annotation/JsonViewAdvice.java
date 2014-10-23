/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JsonViewAdvice.java 2014-10-23 11:10
 */

package com.nonobank.web.annotation;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

/**
 * {@code JsonView} 注解响应体拦截处理。
 *
 * @author fuchun
 * @version $Id: JsonViewAdvice.java 255 2014-10-23 03:11:52Z fuchun $
 * @since 2.0
 */
@ControllerAdvice(annotations = RestController.class)
public class JsonViewAdvice extends JsonViewResponseBodyAdvice {

    public JsonViewAdvice() {
        super();
    }
}
