/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserID5RecordRepositoryTest.java 2014-10-27 16:41
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
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
@DirtiesContext
public class JdbcUserID5RecordRepositoryTest {

    @Resource
    private JdbcUserID5RecordRepository userID5RecordRepository;

    @Test
    public void testFindByUserId() {
        List<UserID5Record> userID5RecordList = userID5RecordRepository.findByUserId(12816L);

        Assert.assertThat(userID5RecordList, IsNull.notNullValue());
    }
}