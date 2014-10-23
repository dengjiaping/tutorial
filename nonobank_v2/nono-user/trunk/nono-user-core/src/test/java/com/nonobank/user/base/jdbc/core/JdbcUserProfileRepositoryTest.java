/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserProfileRepositoryTest.java 2014-10-21 15:04
 */

package com.nonobank.user.base.jdbc.core;

import com.nonobank.user.domain.core.UserProfile;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
@DirtiesContext
public class JdbcUserProfileRepositoryTest {

    @Resource
    private JdbcUserProfileRepository userProfileRepository;

    @Test
    public void testFindOne() {
        UserProfile userProfile = userProfileRepository.findByUserId(2L);

        Assert.assertThat(userProfile, IsNull.notNullValue());
    }
}