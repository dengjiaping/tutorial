/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserAccountRepositoryTest.java 2014-10-22 10:23
 */

package com.nonobank.user.base.jdbc.core;

import com.nonobank.user.domain.core.UserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
@DirtiesContext
public class JdbcUserAccountRepositoryTest {

    @Resource
    private JdbcUserAccountRepository userAccountRepository;

    @Test
    public void testFindByUserName() {
        UserAccount userAccount = userAccountRepository.findByUserName("xuyinhui");

        assertThat(userAccount, notNullValue());
    }

    @Test
    public void testFindByMobileNO() {
        UserAccount userAccount = userAccountRepository.findByMobileNo("13751891276");

        assertThat(userAccount, notNullValue());
    }
}