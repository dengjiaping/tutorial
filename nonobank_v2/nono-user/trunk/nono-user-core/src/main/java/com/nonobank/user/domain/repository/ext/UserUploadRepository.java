/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserUploadRepository.java 2014-10-21 11:37
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.UserUpload;

import java.util.List;

import static com.nonobank.user.domain.ext.QUserUpload.quu;
import static com.nonobank.user.domain.ext.UserUpload.PROP_UPLOAD_TYPE_ID;
import static com.nonobank.user.domain.ext.UserUpload.PROP_USER_ID;
import static java.util.Objects.requireNonNull;

/**
 * 用户上传数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserUploadRepository.java 226 2014-10-21 03:58:47Z yichuan $
 * @since 2.0
 */
public interface UserUploadRepository extends QueryDslRepository<UserUpload, Long> {

    public default List<UserUpload> findByUserId(Long userId) {
        requireNonNull(userId, PROP_USER_ID);
        return findAll(quu.userId.eq(userId));
    }

    public default List<UserUpload> findByTypeId(Long uploadTypeId) {
        requireNonNull(uploadTypeId, PROP_UPLOAD_TYPE_ID);
        return findAll(quu.uploadTypeId.eq(uploadTypeId));
    }
}
