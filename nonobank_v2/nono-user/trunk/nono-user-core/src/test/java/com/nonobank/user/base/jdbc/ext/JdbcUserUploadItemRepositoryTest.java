/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserUploadItemRepositoryTest.java 2014-10-22 11:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.user.domain.ext.UserUploadItem;
import org.hamcrest.core.IsEqual;
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
public class JdbcUserUploadItemRepositoryTest {

    @Resource
    private JdbcUserUploadItemRepository userUploadItemRepository;

    @Test
    public void testFindByUploadId() {
        List<UserUploadItem> itemList = userUploadItemRepository.findByUploadId(20L);

        Assert.assertThat(itemList, IsNull.notNullValue());

        Assert.assertThat(itemList.size(), IsEqual.equalTo(4));
    }
}