/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserUploadDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserUploadDTO implements Serializable {

    private static final long serialVersionUID = -3689957203828343283L;

    private final Long id;
    private final Long userId;
    private final Long uploadTypeId;
    private final String uploadTitle;
    private final String uploadContent;
    private final Short auditStatus;
    private final DateTime auditTime;
    private final Long operatorId;
    private final String operatorName;
    private final Long assignerId;
    private final String assignerName;
    private final DateTime assignTime;
    private final String remarks;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserUploadDTO(Long id, Long userId, Long uploadTypeId, String uploadTitle,
                         String uploadContent, Short auditStatus, DateTime auditTime,
                         Long operatorId, String operatorName, Long assignerId,
                         String assignerName, DateTime assignTime, String remarks,
                         DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.userId = userId;
        this.uploadTypeId = uploadTypeId;
        this.uploadTitle = uploadTitle;
        this.uploadContent = uploadContent;
        this.auditStatus = auditStatus;
        this.auditTime = auditTime;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.assignerId = assignerId;
        this.assignerName = assignerName;
        this.assignTime = assignTime;
        this.remarks = remarks;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }
}
