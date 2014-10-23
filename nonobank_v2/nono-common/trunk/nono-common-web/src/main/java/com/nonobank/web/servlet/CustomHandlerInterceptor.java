/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CustomHandlerInterceptor.java 2014-09-26 11:51
 */

package com.nonobank.web.servlet;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义实现控制器的拦截操作。
 *
 * @author fuchun
 * @version $Id: CustomHandlerInterceptor.java 29 2014-09-26 07:10:32Z fuchun $
 * @since 2.0
 */
public class CustomHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            if (hm.getBean() instanceof CleanAware) {
                ((CleanAware) hm.getBean()).cleanUp();
            }
        }
    }
}
