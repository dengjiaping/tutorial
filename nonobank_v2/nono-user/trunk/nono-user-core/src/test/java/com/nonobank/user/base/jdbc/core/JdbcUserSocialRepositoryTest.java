/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserSocialRepositoryTest.java 2014-10-22 11:15
 */

package com.nonobank.user.base.jdbc.core;

import com.nonobank.user.domain.core.SocialSource;
import com.nonobank.user.domain.core.UserSocial;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
@DirtiesContext
public class JdbcUserSocialRepositoryTest {

    @Resource
    private JdbcUserSocialRepository userSocialRepository;

    @Test
    public void testExistsByAuthToken() {
        Boolean isExist = userSocialRepository.existsByAuthToken("NOE1IOJA93ZNI1IEN21S1A1XC");

        Assert.assertThat(isExist, IsEqual.equalTo(true));
    }

    @Test
    public void testFindByUserIdAndAccSource() {
        UserSocial userSocial = userSocialRepository.findByUserIdAndAccSource(76054L, SocialSource.QQ);

        Assert.assertThat(userSocial, IsNull.notNullValue());
    }

    @Test
    public void testFindByOpenIdAndAccSource() {
        UserSocial userSocial = userSocialRepository.findByOpenIdAndAccSource("E2A13CD8DB4B4C66F23F0E96CCEB420C", SocialSource.QQ);

        Assert.assertThat(userSocial, IsNull.notNullValue());
    }

    @Test
    public void testFindByUserId() {
        List<UserSocial> userSocialList = userSocialRepository.findByUserId(76054L, new Sort(Sort.Direction.DESC, UserSocial.PROP_CREATED_DATE));

        Assert.assertThat(userSocialList, IsNull.notNullValue());
    }
}