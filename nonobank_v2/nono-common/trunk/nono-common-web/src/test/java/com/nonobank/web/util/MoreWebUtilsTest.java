/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) MoreWebUtilsTest.java 2014-10-21 09:20
 */

package com.nonobank.web.util;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestBindingException;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MoreWebUtilsTest {

    private MockHttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        request = new MockHttpServletRequest(
                HttpMethod.POST.name(), "/parameters/test");
        request.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
    }

    @Test
    public void testGetParametersWithSplitter() throws Exception {
        String targetValue = "name, gender,birth,weight,";
        request.setParameter("fields", "name, gender,birth,weight,");

        String[] fields = MoreWebUtils.getParametersWithSplitter(request, "fields",
                Splitter.on(",").trimResults().omitEmptyStrings());

        assertThat(fields, IsNull.notNullValue());
        assertTrue(fields.length == 4);

        String[] target = Iterables.toArray(
                Splitter.on(",").trimResults()
                        .omitEmptyStrings().split(targetValue), String.class);

        assertThat(target, Is.is(fields));

        List<String> fieldList = MoreWebUtils.getParameterListWithSplitter(request, "fields",
                Splitter.on(",").trimResults().omitEmptyStrings());

        assertThat(fieldList, IsNull.notNullValue());
        assertFalse(fieldList.isEmpty());

        List<String> targetList = Splitter.on(",").trimResults()
                .omitEmptyStrings().splitToList(targetValue);

        assertThat(targetList, IsNull.notNullValue());
        assertThat(targetList, Is.is(fieldList));
    }

    @Test
    public void testGetDecimalParameter() throws Exception {
        BigDecimal decimal = MoreWebUtils.getDecimalParameter(request, "money");

        assertThat(decimal, IsNull.nullValue());

        decimal = MoreWebUtils.getDecimalParameter(request, "money", BigDecimal.ZERO);

        assertThat(decimal, IsNull.notNullValue());
        assertThat(decimal, Is.is(BigDecimal.ZERO));
    }

    @Test
    public void testGetRequiredDecimalParameter() throws Exception {
        request.setParameter("money", BigDecimal.TEN.toPlainString());

        BigDecimal decimal = MoreWebUtils.getRequiredDecimalParameter(request, "money");

        assertThat(decimal, IsNull.notNullValue());
        assertThat(decimal, Is.is(BigDecimal.TEN));

        try {
            MoreWebUtils.getRequiredDecimalParameter(request, "price");
        } catch (Exception ex) {
            assertThat(ex, instanceOf(ServletRequestBindingException.class));
        }
    }

    @Test
    public void testGetClientIp1() throws Exception {
        String ip = MoreWebUtils.getClientIp(request);

        assertThat(ip, IsNull.notNullValue());
        assertThat(ip, Is.is("127.0.0.1"));

        String targetIp = "192.168.1.250";

        request.addHeader("X-Forwarded-For", targetIp);

        String ip2 = MoreWebUtils.getClientIp(request);
        assertThat(ip2, IsNull.notNullValue());
        assertThat(ip2, Is.is(targetIp));
    }

    @Test
    public void testGetClientIp2() throws Exception {
        String ip = MoreWebUtils.getClientIp(request);

        assertThat(ip, IsNull.notNullValue());
        assertThat(ip, Is.is("127.0.0.1"));

        String targetIp = "192.168.1.250";

        request.addHeader("Proxy-Client-IP", targetIp);

        String ip2 = MoreWebUtils.getClientIp(request);
        assertThat(ip2, IsNull.notNullValue());
        assertThat(ip2, Is.is(targetIp));
    }

    @Test
    public void testGetClientIp3() throws Exception {
        String ip = MoreWebUtils.getClientIp(request);

        assertThat(ip, IsNull.notNullValue());
        assertThat(ip, Is.is("127.0.0.1"));

        String targetIp = "192.168.1.250";

        request.addHeader("WL-Proxy-Client-IP", targetIp);

        String ip2 = MoreWebUtils.getClientIp(request);
        assertThat(ip2, IsNull.notNullValue());
        assertThat(ip2, Is.is(targetIp));
    }

    @Test
    public void testGetClientIp4() throws Exception {
        String ip = MoreWebUtils.getClientIp(request);

        assertThat(ip, IsNull.notNullValue());
        assertThat(ip, Is.is("127.0.0.1"));

        String targetIp = "192.168.1.250";

        request.addHeader("HTTP_CLIENT_IP", targetIp);

        String ip2 = MoreWebUtils.getClientIp(request);
        assertThat(ip2, IsNull.notNullValue());
        assertThat(ip2, Is.is(targetIp));
    }

    @Test
    public void testGetClientIp5() throws Exception {
        String ip = MoreWebUtils.getClientIp(request);

        assertThat(ip, IsNull.notNullValue());
        assertThat(ip, Is.is("127.0.0.1"));

        String targetIp = "192.168.1.250";

        request.addHeader("HTTP_X_FORWARDED_FOR", targetIp);

        String ip2 = MoreWebUtils.getClientIp(request);
        assertThat(ip2, IsNull.notNullValue());
        assertThat(ip2, Is.is(targetIp));
    }
}