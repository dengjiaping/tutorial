/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserEducationService.java 2014-10-27 16:41
 */

package com.nonobank.user.service;

import com.nonobank.user.domain.ext.UserEducation;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author Yichuan
 * @version $Id: UserEducationService.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface UserEducationService {

    /**
     * 查询指定用户的教育经历信息
     * <p />
     *  按入学年份倒序排列
     *
     * @param userId 用户ID
     */
    @Nonnull
    public List<UserEducation> findByUserId(Long userId);

    /**
     * 保存指定用户的教育经历
     *
     * @param userId 用户ID
     * @param userEducation 用户教育经历
     */
    @Nonnull
    public UserEducation saveEducation(Long userId, UserEducation userEducation);

    /**
     * 保存指定用户的教育经历
     *
     * @param userId 用户ID
     * @param userEducationList 用户教育经历集合
     */
    public void saveEducations(Long userId, List<UserEducation> userEducationList);
}
