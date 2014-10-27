/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) DefaultWebApplicationFilter.java 2014-10-27 16:47
 */

package com.nonobank.web.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * 用于移除请求的URL中携带的{@code JSESSIONID} 字符串（jetty or tomcat）；
 * 设置请求编码，过滤不安全的请求等。
 *
 * @author fuchun
 * @version $Id: DefaultWebApplicationFilter.java 290 2014-10-27 08:48:18Z fuchun $
 * @since 2.0
 */
public class DefaultWebApplicationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        final String requestURI = request.getRequestURI();
        // 不能直接访问非安全信息
        if (requestURI.contains("/WEB-INF/")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Redirect requests with JSESSIONID in URL to clean version (old links
        // bookmarked/stored by bots). This is ONLY triggered if the request did
        // not also contain a JSESSIONID cookie! Which should be fine for bots
        if (request.isRequestedSessionIdFromURL()) {
            String url = request.getRequestURL()
                    .append(request.getQueryString() != null ? "?" + request.getQueryString() : "")
                    .toString();

            // the JSESSIONID path parameter automatically (Jetty does not?!)
            response.setHeader("Location", url);
            response.sendError(HttpServletResponse.SC_MOVED_PERMANENTLY);
            return;
        }

        request.setCharacterEncoding("UTF-8");

        // Prevent rendering of JSESSIONID in URLs for all outgoing links
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(response) {

            @Override
            @SuppressWarnings("all")
            public String encodeRedirectUrl(String url) {
                return url;
            }

            @Override
            public String encodeRedirectURL(String url) {
                return url;
            }

            @Override
            @SuppressWarnings("all")
            public String encodeUrl(String url) {
                return encodeURL(url);
            }

            @Override
            public String encodeURL(String url) {
                return url;
            }
        };
        filterChain.doFilter(request, wrappedResponse);
    }
}
