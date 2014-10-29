/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) BaseMethodArgumentResolver.java 2014-10-29 09:45
 */

package com.nonobank.web.method;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Map;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;
import static org.springframework.web.servlet.HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE;

/**
 * @author fuchun
 * @version $Id: BaseMethodArgumentResolver.java 297 2014-10-29 03:03:33Z fuchun $
 * @since 2.0
 */
public abstract class BaseMethodArgumentResolver implements HandlerMethodArgumentResolver {


    @Nonnull
    protected final Map<String, String> getUriTemplateVariables(NativeWebRequest request) {
        @SuppressWarnings("unchecked")
        Map<String, String> variables =
                (Map<String, String>) request.getAttribute(
                        URI_TEMPLATE_VARIABLES_ATTRIBUTE, SCOPE_REQUEST);
        return (variables != null) ? variables : Collections.<String, String>emptyMap();
    }
}
