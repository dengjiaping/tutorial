/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserAuthcRepositoryTest.java 2014-10-22 10:54
 */

package com.nonobank.user.base.jdbc.core;

import com.nonobank.user.domain.core.UserAuthc;
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
public class JdbcUserAuthcRepositoryTest {

    @Resource
    private JdbcUserAuthcRepository userAuthcRepository;

    @Test
    public void testFindByOne() {
        UserAuthc userAuthc = userAuthcRepository.findOne(1013L);

        Assert.assertThat(userAuthc, IsNull.notNullValue());
    }
}