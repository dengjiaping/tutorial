/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserFieldRepositoryTest.java 2014-10-16 15:58
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.user.domain.ext.UserField;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
public class JdbcUserFieldRepositoryTest {

    @Resource
    private JdbcUserFieldRepository userFieldRepository;

    @Test
    public void testFindById() {
        UserField userField = userFieldRepository.findOne(3L);

        Assert.assertThat(userField, IsNull.notNullValue());
    }

    @Test
    public void testFindByKwd() {
        UserField userField = userFieldRepository.findByKwd("email");

        Assert.assertThat(userField, IsNull.notNullValue());
    }
}