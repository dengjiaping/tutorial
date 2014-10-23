/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) BeanUtilsBeanHashMapperTest.java 2014-10-08 15:22
 */

package com.nonobank.data.redis;

import com.nonobank.data.convert.beanutils.EnumConverter;
import com.nonobank.data.convert.beanutils.JodaDateTimeConverter;
import com.nonobank.data.domain.TUserStatus;
import com.nonobank.data.domain.TestDomain;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * BeanUtilsBeanHashMapper test case.
 *
 * @version $Id: BeanUtilsBeanHashMapperTest.java 47 2014-10-08 07:39:43Z fuchun $
 */
public class BeanUtilsBeanHashMapperTest {

    private BeanUtilsBeanHashMapper<TestDomain> hashMapper;

    @Before
    public void setUp() throws Exception {
        hashMapper = new BeanUtilsBeanHashMapper<>(TestDomain.class);

        BeanUtilsBean bub = hashMapper.getBeanUtilsBean();

        bub.getConvertUtils().register(new JodaDateTimeConverter(), DateTime.class);
        bub.getConvertUtils().register(new EnumConverter<>(
                TUserStatus.class, TUserStatus.CREATED), TUserStatus.class);
    }

    @Test
    public void testConverter() throws Exception {
        TestDomain td = TestDomain.newInstance(
                "Jack", TUserStatus.VALIDATED).id(10001);

        Map<String, String> map = hashMapper.toHash(td);

        Assert.assertThat(map, IsNull.notNullValue());
        Assert.assertTrue(map.containsKey(TestDomain.PROP_NAME));
        Assert.assertTrue(map.containsKey(TestDomain.PROP_STATUS));

        TestDomain target = hashMapper.fromHash(map);

        Assert.assertThat(target, IsNull.notNullValue());
        Assert.assertThat(target, Is.is(td));
    }
}