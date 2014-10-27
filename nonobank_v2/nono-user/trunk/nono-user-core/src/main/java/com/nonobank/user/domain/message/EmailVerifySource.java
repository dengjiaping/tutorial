/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EmailVerifySource.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.message;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import com.nonobank.data.domain.RecordStatus;
import com.nonobank.user.domain.exception.UserException;
import org.joda.time.DateTime;

/**
 * 邮件验证(链接)信息
 *
 * @author Yichuan
 * @version $Id: EmailVerifySource.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class EmailVerifySource extends AbstractRecording<Long, EmailVerifySource> {

    public static final String PROP_TOKEN = "token";
    public static final String PROP_TYPE = "type";
    public static final String PROP_CONTENT = "content";
    public static final String PROP_DEADLINE = "deadline";
    public static final String PROP_USE_TIMES = "useTimes";
    public static final String PROP_STATUS = "status";

    private static final long serialVersionUID = -2539304231932471952L;

    // 用户ID
    private Long userId;
    // 验证业务类型
    private BusinessType type;
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

    public BusinessType getType() {
        return type;
    }

    public void setType(BusinessType type) {
        this.type = type;
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
                .add(PROP_TYPE, getType())
                .add(PROP_TOKEN, getToken())
                .add(PROP_CONTENT, getContent())
                .add(PROP_DEADLINE, getDeadline())
                .add(PROP_USE_TIMES, getUseTimes())
                .add(PROP_STATUS, getStatus()).toString();
    }

    /**
     * 邮件链接token有效验证
     */
    public EmailVerifySource verify() {
        // 无效判断
        if (getStatus().equals(RecordStatus.DELETED)) {
            throw new UserException("");
        }
        DateTime now = DateTime.now();
        // 过期判断
        if (getDeadline() != null && now.getMillis() > getDeadline()) {
            throw new UserException("");
        }
        Integer times = getUseTimes();
        if (times == null) times = 0;
        // 无法使用判断(别使用过，并且没有剩余使用次数)
        if (getStatus().equals(RecordStatus.CREATED) && times == 0) {
            throw new UserException("");
        }
        if (times > 0) setUseTimes(times - 1);
        setStatus(RecordStatus.CREATED);
        setLastModifiedDate(now);
        return this;
    }
}

