/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CustomHandlerInterceptor.java 2014-10-27 16:47
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
 * @version $Id: CustomHandlerInterceptor.java 290 2014-10-27 08:48:18Z fuchun $
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
