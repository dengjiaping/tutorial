/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserCriminal.java 2014-10-29 13:51
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;

/**
 * 用户刑侦查询信息
 *
 * @author Yichuan
 * @version $Id: UserCriminal.java 317 2014-10-30 09:20:04Z yichuan $
 * @since 2.0
 */
public class UserCriminal extends AbstractRecording<Long, UserCriminal> {

    public static final String PROP_CRIMINAL_STATUS = "criminalStatus";
    public static final String PROP_CRIMINAL_INFO = "criminalInfo";

    private static final long serialVersionUID = -656904734639665293L;

    private Long userId;
    private String userName;
    private String criminalStatus;
    private String criminalInfo;

    public UserCriminal() {
        super();
    }

    // full constructor
    public UserCriminal(Long userId, String userName, String criminalStatus, String criminalInfo) {
        this.userId = userId;
        this.userName = userName;
        this.criminalStatus = criminalStatus;
        this.criminalInfo = criminalInfo;
    }

    public static UserCriminal create(Long userId, String userName, String criminalStatus, String criminalInfo) {
        return new UserCriminal(userId, userName, criminalStatus, criminalInfo);
    }

    /**
     * 更新刑侦状态
     *
     * @param criminalStatus    状态
     * @param criminalInfo      描述
     */
    public UserCriminal updateStatus(String criminalStatus, String criminalInfo) {
        setCriminalStatus(criminalStatus);
        setCriminalInfo(criminalInfo);
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCriminalStatus() {
        return criminalStatus;
    }

    public void setCriminalStatus(String criminalStatus) {
        this.criminalStatus = criminalStatus;
    }

    public String getCriminalInfo() {
        return criminalInfo;
    }

    public void setCriminalInfo(String criminalInfo) {
        this.criminalInfo = criminalInfo;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_ID, getId())
                .add(PROP_USER_ID, getUserId())
                .add(PROP_USER_NAME, getUserName())
                .add(PROP_CRIMINAL_STATUS, getCriminalStatus())
                .add(PROP_CRIMINAL_INFO, getCriminalInfo())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
