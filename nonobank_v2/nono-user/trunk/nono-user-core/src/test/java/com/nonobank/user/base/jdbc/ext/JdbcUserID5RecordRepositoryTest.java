/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserID5RecordRepositoryTest.java 2014-10-22 13:33
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.user.domain.ext.UserID5Record;
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
public class JdbcUserID5RecordRepositoryTest {

    @Resource
    private JdbcUserID5RecordRepository userID5RecordRepository;

    @Test
    public void testFindByUserId() {
        UserID5Record userID5Record = userID5RecordRepository.findByUserId(12816L);

        Assert.assertThat(userID5Record, IsNull.notNullValue());
    }
}