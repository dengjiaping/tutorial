/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserUpload.java 2014-10-20 16:46
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import com.nonobank.user.domain.ext.common.UploadAuditStatus;
import org.joda.time.DateTime;

/**
 * 用户上传信息实体
 *
 * @author Yichuan
 * @version $Id: UserUpload.java 226 2014-10-21 03:58:47Z yichuan $
 * @since 2.0
 */
public class UserUpload extends AbstractRecording<Long, UserUpload> {

    public static final String PROP_UPLOAD_TYPE_ID = "uploadTypeId";
    public static final String PROP_UPLOAD_TITLE = "uploadTitle";
    public static final String PROP_UPLOAD_CONTENT = "uploadContent";
    public static final String PROP_AUDIT_STATUS = "auditStatus";
    public static final String PROP_AUDIT_TIME = "auditTime";
    public static final String PROP_OPERATOR_ID = "operatorId";
    public static final String PROP_OPERATOR_NAME = "operatorName";
    public static final String PROP_ASSIGNER_ID = "assignerId";
    public static final String PROP_ASSIGNER_NAME = "assignerName";
    public static final String PROP_ASSIGN_TIME = "assignTime";
    public static final String PROP_REMARKS = "remarks";

    private static final long serialVersionUID = 6465066703190679599L;

    private Long userId;
    private Long uploadTypeId;
    private String uploadTitle;
    private String uploadContent;
    private UploadAuditStatus auditStatus;
    private DateTime auditTime;
    private Long operatorId;
    private String operatorName;
    private Long assignerId;
    private String assignerName;
    private DateTime assignTime;
    private String remarks;

    public UserUpload() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUploadTypeId() {
        return uploadTypeId;
    }

    public void setUploadTypeId(Long uploadTypeId) {
        this.uploadTypeId = uploadTypeId;
    }

    public String getUploadTitle() {
        return uploadTitle;
    }

    public String getUploadContent() {
        return uploadContent;
    }

    public void setUploadContent(String uploadContent) {
        this.uploadContent = uploadContent;
    }

    public void setUploadTitle(String uploadTitle) {
        this.uploadTitle = uploadTitle;
    }

    public UploadAuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(UploadAuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public DateTime getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(DateTime auditTime) {
        this.auditTime = auditTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getAssignerId() {
        return assignerId;
    }

    public void setAssignerId(Long assignerId) {
        this.assignerId = assignerId;
    }

    public String getAssignerName() {
        return assignerName;
    }

    public void setAssignerName(String assignerName) {
        this.assignerName = assignerName;
    }

    public DateTime getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(DateTime assignTime) {
        this.assignTime = assignTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_UPLOAD_TYPE_ID, getUploadTypeId())
                .add(PROP_UPLOAD_TITLE, getUploadTitle())
                .add(PROP_UPLOAD_CONTENT, getUploadContent())
                .add(PROP_AUDIT_STATUS, getAuditStatus())
                .add(PROP_AUDIT_TIME, getAuditTime())
                .add(PROP_OPERATOR_ID, getOperatorId())
                .add(PROP_OPERATOR_NAME, getOperatorName())
                .add(PROP_ASSIGNER_ID, getAssignerId())
                .add(PROP_ASSIGNER_NAME, getAssignerName())
                .add(PROP_ASSIGN_TIME, getAssignTime())
                .add(PROP_REMARKS, getRemarks()).toString();
    }
}
