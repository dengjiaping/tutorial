/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) MoreWebUtils.java 2014-10-27 16:47
 */

package com.nonobank.web.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

/**
 * Web应用的实用工具类。对 spring-web 的{@code WebUtils} 和{@code ServletRequestUtils}
 * 是一个很好的补充。
 *
 * @author fuchun
 * @version $Id: MoreWebUtils.java 290 2014-10-27 08:48:18Z fuchun $
 * @since 2.0
 */
public abstract class MoreWebUtils {

    private static final String UNKNOWN_IP = "unknown";

    /**
     * Get an array of String parameters, return an empty array if not found.
     * <pre>{@code
     * path: /path?fields=name,gender,,birthday
     * String[] fields = MoreWebUtils.getParametersWithSplitter(request, "fields",
     *         Splitter.on(",").trimResults().omitEmptyStrings());
     * // ["name", "gender", "birthday"]
     *
     * NOTE: Not /path?field=name&field=gender&field=birthday
     * this method use ServletRequestUtils.getStringParameters()
     * }</pre>
     *
     * @param request current HTTP request
     * @param name the name of the parameter
     * @param splitter parameter value splitter.
     */
    @Nonnull
    public static String[] getParametersWithSplitter(
            @Nonnull ServletRequest request, String name, Splitter splitter) {
        String value = ServletRequestUtils.getStringParameter(request, name, null);
        if (value == null) {
            return new String[0];
        } else {
            Iterable<String> it = splitter.split(value);
            return Iterables.toArray(it, String.class);
        }
    }

    /**
     * Get a list of String parameters, return an empty list if not found.
     * <pre>{@code
     * path: /path?fields=name,gender,,birthday
     * List<String> fields = MoreWebUtils.getParameterListWithSplitter(request, "fields",
     *         Splitter.on(",").trimResults().omitEmptyStrings());
     * // ["name", "gender", "birthday"]
     *
     * NOTE: Not /path?field=name&field=gender&field=birthday
     * this method use ServletRequestUtils.getStringParameters()
     * }</pre>
     *
     * @param request current HTTP request
     * @param name the name of the parameter
     * @param splitter parameter value splitter.
     */
    @Nonnull
    public static List<String> getParameterListWithSplitter(
            @Nonnull ServletRequest request, String name, Splitter splitter) {
        String value = ServletRequestUtils.getStringParameter(request, name, null);
        if (value == null) {
            return Collections.emptyList();
        } else {
            return splitter.splitToList(value);
        }
    }

    public static BigDecimal getDecimalParameter(
            @Nonnull ServletRequest request, String name)
            throws ServletRequestBindingException {
        if (request.getParameter(name) == null) {
            return null;
        }
        return getRequiredDecimalParameter(request, name);
    }

    public static BigDecimal getDecimalParameter(
            @Nonnull ServletRequest request, String name, @Nullable BigDecimal defaultValue) {
        if (request.getParameter(name) == null) {
            return defaultValue;
        }
        try {
            return getRequiredDecimalParameter(request, name);
        } catch (ServletRequestBindingException ex) {
            return defaultValue;
        }
    }

    public static BigDecimal getRequiredDecimalParameter(
            @Nonnull ServletRequest request, String name)
            throws ServletRequestBindingException {
        String value;
        if ((value = request.getParameter(name)) == null) {
            throw new MissingServletRequestParameterException(name, Number.class.getSimpleName());
        }
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException ex) {
            throw new ServletRequestBindingException(
                    "Required decimal parameter '" + name + "' with value of '" +
                            value + "' is not a valid number", ex);
        }
    }

    /**
     * 获取当前Http请求的客户端的真实IP。若取不到IP值，则返回空字符串（&quot;&quot;）。
     *
     * @param request 当前Web应用的 {@code HttpServletRequest} 请求对象。
     * @return 当前Http请求的客户端的真实IP串。
     */
    public static String getClientIp(@Nonnull HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (!hasText(ip) || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (!hasText(ip) || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (!hasText(ip) || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (!hasText(ip) || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (!hasText(ip) || UNKNOWN_IP.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
