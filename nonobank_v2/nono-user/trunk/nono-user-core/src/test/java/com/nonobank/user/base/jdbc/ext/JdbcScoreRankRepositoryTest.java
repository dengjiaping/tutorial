/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcScoreRankRepositoryTest.java 2014-10-15 15:37
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.common.json.JsonMapper;
import com.nonobank.user.domain.ext.ScoreRank;
import com.nonobank.user.domain.ext.capital.ScoreCapitalInfo;
import com.nonobank.user.domain.ext.common.ImageProp;
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
public class JdbcScoreRankRepositoryTest {

    @Resource
    private JdbcScoreRankRepository scoreRankRepository;

    @Test
    public void testFindByScore() throws Exception {
        ScoreRank scoreRank = scoreRankRepository.findByScore(85);

        assertThat(scoreRank, IsNull.notNullValue());

        String icon = scoreRank.getRankIcon();

        assertThat(icon, IsNull.notNullValue());

        ImageProp imageProp = JsonMapper.getDefault().readValue(icon, ImageProp.class);

        assertThat(imageProp, IsNull.notNullValue());

        String capital = scoreRank.getScoreCapitalInfo();

        assertThat(capital, IsNull.notNullValue());

        List<ScoreCapitalInfo> list = JsonMapper.getDefault().readToList(capital, ScoreCapitalInfo.class);

        assertThat(list, IsNull.notNullValue());
    }
}