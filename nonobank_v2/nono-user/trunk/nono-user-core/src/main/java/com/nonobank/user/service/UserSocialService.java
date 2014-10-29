/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserSocialService.java 2014-10-27 16:41
 */

package com.nonobank.user.service;

import com.nonobank.user.domain.core.SocialSource;
import com.nonobank.user.domain.core.UserSocial;

import java.util.List;

/**
 * @author Yichuan
 * @version $Id: UserSocialService.java 300 2014-10-29 08:32:39Z yichuan $
 * @since 2.0
 */
public interface UserSocialService {

    /**
     * 查询指定用户的社交信息
     *
     * @param userId    用户ID
     */
    public List<UserSocial> findByUserId(Long userId);

    /**
     * 查询指定渠道用户的社交信息
     *
     * @param userId        用户ID
     * @param socialSource  社交来源(渠道)
     */
    public UserSocial findByUserIdAndSource(Long userId, SocialSource socialSource);
}
