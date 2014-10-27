/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CommonDictRepositoryMockTest.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.repository;

import com.google.common.collect.ImmutableList;
import com.nonobank.user.domain.ctx.DictCmdContext;
import com.nonobank.user.domain.dict.CommonDict;
import com.nonobank.user.domain.dict.Dict;
import com.nonobank.user.domain.dict.UserDict;
import com.nonobank.user.domain.repository.dict.CommonDictRepository;
import org.easymock.EasyMock;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

import static com.nonobank.user.domain.dict.UserDict.MARRIAGE;
import static org.junit.Assert.assertThat;

/**
 * {@code MixedDictRepository} mock test case.
 */
public class CommonDictRepositoryMockTest {

    private static final ImmutableList<CommonDict> marriages;

    static {
        ImmutableList.Builder<CommonDict> builder = ImmutableList.builder();
        builder.add(new CommonDict(1, MARRIAGE, "1", "marriage.unmarried", "未婚", 1));
        builder.add(new CommonDict(2, MARRIAGE, "2", "marriage.premarital", "未婚有育", 2));
        builder.add(new CommonDict(3, MARRIAGE, "3", "marriage.married_nulliparous", "已婚未育", 3));
        builder.add(new CommonDict(4, MARRIAGE, "4", "marriage.married_procreated", "已婚已育", 4));
        builder.add(new CommonDict(5, MARRIAGE, "5", "marriage.divorced", "离异", 5));
        builder.add(new CommonDict(6, MARRIAGE, "6", "marriage.widowed", "丧偶", 6));

        marriages = builder.build();
    }

    private CommonDictRepository commonDictRepository;

    @Before
    public void setUp() throws Exception {
        commonDictRepository = EasyMock.createMock(CommonDictRepository.class);
        DictCmdContext.getContext().setCommonDictRepository(commonDictRepository);
    }

    @Test
    public void testFindByTypeKey() throws Exception {
        EasyMock.expect(commonDictRepository.findByTypeKey(
                MARRIAGE, null))
                .andReturn(marriages);
        EasyMock.replay(commonDictRepository);

        ImmutableList<Dict> marriageList = UserDict.findMarriages(null);

        assertThat(marriageList, IsNull.notNullValue());
        assertThat(marriageList, Is.is(marriages));
    }
}