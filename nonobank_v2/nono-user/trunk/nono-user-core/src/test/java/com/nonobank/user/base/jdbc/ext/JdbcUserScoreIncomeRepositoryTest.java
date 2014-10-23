/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserScoreIncomeRepositoryTest.java 2014-10-17 13:30
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.user.domain.ext.UserScoreIncome;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/test-context.xml")
public class JdbcUserScoreIncomeRepositoryTest {

    @Resource
    private JdbcUserScoreIncomeRepository userScoreIncomeRepository;

    @Test
    public void testFindById() {
        UserScoreIncome userScoreIncome = userScoreIncomeRepository.findOne(455L);

        Assert.assertThat(userScoreIncome, IsNull.notNullValue());
    }

    @Test
    public void testFindByUserId() {
        List<UserScoreIncome> incomeList = userScoreIncomeRepository.findByUserId(16L);

        Assert.assertThat(incomeList, IsNull.notNullValue());
    }
}