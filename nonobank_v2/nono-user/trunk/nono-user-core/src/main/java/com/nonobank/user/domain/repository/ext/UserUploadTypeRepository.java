/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserUploadTypeRepository.java 2014-10-20 14:19
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.UserUploadType;

/**
 * 用户上传类型数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserUploadTypeRepository.java 219 2014-10-20 06:48:31Z yichuan $
 * @since 2.0
 */
public interface UserUploadTypeRepository extends QueryDslRepository<UserUploadType, Long> {
}
