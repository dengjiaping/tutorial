/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserUploadItemRepository.java 2014-10-20 16:07
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.UserUploadItem;

import java.util.List;
import java.util.Objects;

import static com.nonobank.user.domain.ext.QUserUploadItem.quui;
import static com.nonobank.user.domain.ext.UserUploadItem.PROP_UPLOAD_ID;

/**
 * 用户上传信息数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserUploadItemRepository.java 220 2014-10-20 08:33:35Z yichuan $
 * @since 2.0
 */
public interface UserUploadItemRepository extends QueryDslRepository<UserUploadItem, Long> {

    public default List<UserUploadItem> findByUploadId(Long uploadId) {
        Objects.requireNonNull(uploadId, PROP_UPLOAD_ID);
        return findAll(quui.uploadId.eq(uploadId));
    }
}
