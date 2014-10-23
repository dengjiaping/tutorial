/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserUploadRepositoryTest.java 2014-10-21 11:43
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.user.domain.ext.UserUpload;
import com.nonobank.user.domain.ext.common.UploadAuditStatus;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
public class JdbcUserUploadRepositoryTest {

    @Resource
    private JdbcUserUploadRepository userUploadRepository;

    @Test
    public void testFindByUserId() {
        List<UserUpload> uploadList = userUploadRepository.findByUserId(56L);

        assertThat(uploadList, IsNull.notNullValue());

        assertThat(uploadList.size(), IsEqual.equalTo(2));
    }

    @Test
    public void testFindByOne() {
        UserUpload refuse = userUploadRepository.findOne(45614L);

        assertThat(refuse, IsNull.notNullValue());

        assertThat(refuse.getAuditStatus(), IsEqual.equalTo(UploadAuditStatus.AUDIT_REFUSE));

        UserUpload pass = userUploadRepository.findOne(45615L);

        assertThat(pass, IsNull.notNullValue());

        assertThat(pass.getAuditStatus(), IsEqual.equalTo(UploadAuditStatus.AUDIT_PASS));
    }

    @Test
    public void testFindByTypeId() {
        List<UserUpload> list = userUploadRepository.findByTypeId(1L);

        assertThat(list, IsNull.notNullValue());
    }
}