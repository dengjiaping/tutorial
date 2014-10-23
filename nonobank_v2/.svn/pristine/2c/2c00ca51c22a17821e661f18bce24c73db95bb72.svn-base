/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcScoreTypeRepositoryTest.java 2014-10-16 10:35
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.user.domain.ext.ScoreAlloc;
import com.nonobank.user.domain.ext.common.ScoreAllocType;
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
public class JdbcScoreAllocRepositoryTest {

    @Resource
    private JdbcScoreAllocRepository scoreAllocRepository;

    @Test
    public void testFindById() {
        ScoreAlloc scoreAlloc;

        scoreAlloc = scoreAllocRepository.findOne(3L);

        assertThat(scoreAlloc, IsNull.notNullValue());

        assertThat(scoreAlloc.getAllocType(), IsEqual.equalTo(ScoreAllocType.USER_PROP));

        scoreAlloc = scoreAllocRepository.findOne(8L);

        assertThat(scoreAlloc, IsNull.notNullValue());

        assertThat(scoreAlloc.getAllocType(), IsEqual.equalTo(ScoreAllocType.ACTIVITY));
    }

    @Test
    public void testFindByKeyword() {
        ScoreAlloc scoreAlloc1 = scoreAllocRepository.findByKeyword("email");

        assertThat(scoreAlloc1, IsNull.notNullValue());

        ScoreAlloc scoreAlloc2 = scoreAllocRepository.findByKeyword("test");

        assertThat(scoreAlloc2, IsNull.nullValue());
    }

    @Test
    public void testFindByAllocType() {
        List<ScoreAlloc> activityList = scoreAllocRepository.findByAllocType(ScoreAllocType.ACTIVITY);

        assertThat(activityList, IsNull.notNullValue());

        List<ScoreAlloc> propList = scoreAllocRepository.findByAllocType(ScoreAllocType.USER_PROP);

        assertThat(propList, IsNull.notNullValue());
    }
}