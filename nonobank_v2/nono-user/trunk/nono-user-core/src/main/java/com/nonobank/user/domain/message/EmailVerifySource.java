/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) EmailSource.java 2014-10-11 15:19
 */

package com.nonobank.user.domain.message;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import com.nonobank.data.domain.RecordStatus;

/**
 * 邮件验证(链接)信息
 *
 * @author Yichuan
 * @version $Id: EmailVerifySource.java 140 2014-10-13 07:15:12Z yichuan $
 * @since 2.0
 */
public class EmailVerifySource extends AbstractRecording<Long, EmailVerifySource> {

    public static final String PROP_TOKEN = "token";
    public static final String PROP_CONTENT = "content";
    public static final String PROP_DEADLINE = "deadline";
    public static final String PROP_USE_TIMES = "useTimes";
    public static final String PROP_STATUS = "status";

    private static final long serialVersionUID = -2539304231932471952L;

    // 用户ID
    private Long userId;
    // 加密token
    private String token;
    // 实际内容
    private String content;
    // 有效时间
    private Long deadline;
    // 有效次数
    private Integer useTimes;
    // 状态(-1失效  0未验证 1已验证)
    private RecordStatus status;

    // empty constructor
    public EmailVerifySource() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public Integer getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Integer useTimes) {
        this.useTimes = useTimes;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_TOKEN, getToken())
                .add(PROP_CONTENT, getContent())
                .add(PROP_DEADLINE, getDeadline())
                .add(PROP_USE_TIMES, getUseTimes())
                .add(PROP_STATUS, getStatus()).toString();
    }
}
