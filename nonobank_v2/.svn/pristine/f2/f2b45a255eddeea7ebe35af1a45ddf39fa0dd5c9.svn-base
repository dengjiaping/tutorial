/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserEducationRepositoryTest.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.user.domain.ext.UserEducation;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
@DirtiesContext
public class JdbcUserEducationRepositoryTest {

    @Resource
    private JdbcUserEducationRepository userEducationRepository;

    @Test
    public void testFindByUserId() {
        List<UserEducation> userEducationList = userEducationRepository.findByUserId(1L);

        assertThat(userEducationList, IsNull.notNullValue());

        userEducationList = userEducationRepository.findByUserId(1L,
                new Sort(Sort.Direction.DESC, UserEducation.PROP_START_YEAR));

        assertThat(userEducationList, IsNull.notNullValue());
    }
}