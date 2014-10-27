/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserUploadTypeRepositoryTest.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.user.domain.ext.UserUploadType;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
public class JdbcUserUploadTypeRepositoryTest {

    @Resource
    private JdbcUserUploadTypeRepository userUploadTypeRepository;

    @Test
    public void testFindById() {
        UserUploadType userUploadType = userUploadTypeRepository.findOne(8L);

        Assert.assertThat(userUploadType, IsNull.notNullValue());
    }
}