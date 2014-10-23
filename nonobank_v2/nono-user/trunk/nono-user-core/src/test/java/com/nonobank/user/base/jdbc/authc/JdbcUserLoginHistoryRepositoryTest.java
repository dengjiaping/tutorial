/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserLoginHistoryRepositoryTest.java 2014-10-22 09:27
 */

package com.nonobank.user.base.jdbc.authc;

import com.nonobank.user.domain.authc.UserDevice;
import com.nonobank.user.domain.authc.UserLoginHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
@DirtiesContext
public class JdbcUserLoginHistoryRepositoryTest {

    @Resource
    private JdbcUserLoginHistoryRepository userLoginHistoryRepository;

    @Test
    public void testFindByUserId() {
        List<UserLoginHistory> historyList = userLoginHistoryRepository.findByUserId(10L);

        assertThat(historyList, notNullValue());
    }

    @Test
    public void testFindByUserIdAndDevice() {
        UserLoginHistory userLoginHistory = userLoginHistoryRepository.findByUserIdAndDevice(10L, UserDevice.ANDROID);

        assertThat(userLoginHistory, notNullValue());
    }
}