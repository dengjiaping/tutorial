/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EmailVerifySourceDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.message;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id: EmailVerifySourceDTO.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class EmailVerifySourceDTO implements Serializable {

    private static final long serialVersionUID = 3315013256512870285L;

    private final Long id;
    private final Long userId;
    private final String token;
    private final String content;
    private final Long deadline;
    private final Integer useTimes;
    private final Short status;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public EmailVerifySourceDTO(Long id, Long userId, String token, String content,
                                Long deadline, Integer useTimes, Short status,
                                DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.userId = userId;
        this.token = token;
        this.content = content;
        this.deadline = deadline;
        this.useTimes = useTimes;
        this.status = status;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getContent() {
        return content;
    }

    public Long getDeadline() {
        return deadline;
    }

    public Integer getUseTimes() {
        return useTimes;
    }

    public Short getStatus() {
        return status;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("EmailVerifySourceDTO{id=%d, userId=%d, token='%s', content='%s', " +
                "deadline=%d, useTimes=%d, status=%d, lastModifiedDate='%s', createdDate='%s'}",
                id, userId, token, content, deadline, useTimes, status, lastModifiedDate, createdDate);
    }
}
