/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserLoginHistory.java 2014-10-09 15:22
 */

package com.nonobank.user.domain.authc;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import org.joda.time.DateTime;

import java.util.Objects;

/**
 * 用户登录历史快照信息实体。
 * <pre>当用户第一次登录时：{@code
 * prevLoginTime = null;
 * prevLoginIp = null;
 * prevUserAgent = null;
 * }
 * </pre>
 *
 * @author fuchun
 * @version $Id: UserLoginHistory.java 131 2014-10-13 06:05:02Z fuchun $
 * @since 2.0
 */
public class UserLoginHistory extends AbstractRecording<Long, UserLoginHistory> {

    public static final String PROP_DEVICE = "device";
    public static final String PROP_LOGIN_FIELD = "loginField";
    public static final String PROP_LAST_USER_AGENT = "lastUserAgent";
    public static final String PROP_LAST_LOGIN_TIME = "lastLoginTime";
    public static final String PROP_LAST_LOGIN_IP = "lastLoginIp";
    public static final String PROP_LAST_TOKEN = "lastToken";
    public static final String PROP_PREV_USER_AGENT = "prevUserAgent";
    public static final String PROP_PREV_LOGIN_TIME = "prevLoginTime";
    public static final String PROP_PREV_LOGIN_IP = "prevLoginIp";
    public static final String PROP_PREV_TOKEN = "prevToken";
    public static final String PROP_LOGIN_COUNT = "loginCount";
//    public static final String PROP_TOTAL_ERRORS = "totalErrors";
//    public static final String PROP_CONSTANT_ERROrs = "constantErrors";
//    public static final String PROP_ERROR_DATE = "errorDate";
//    public static final String PROP_ERROR_LOGIN_IP = "errorLoginIp";

    private static final long serialVersionUID = -1602567623302114302L;

    private Long userId;
    /* 用户名进行冗余。*/
    private String userName;
    private UserDevice device;
    /** 登录的属性（用户名、手机号）。*/
    private String loginField;
    private String lastUserAgent;
    /* 最后一次登录日期时间。*/
    private DateTime lastLoginTime;
    private String lastLoginIp;
    private String lastToken;

    private String prevUserAgent;
    /* 上一次登录日期时间。*/
    private DateTime prevLoginTime;
    private String prevLoginIp;
    private String prevToken;

    /**
     * 登录次数（根据设备单独统计）。
     */
    private Integer loginCount;

//    /** 总计的登录错误次数。*/
//    private Integer totalErrors;
//    /** 会话内的登录错误次数。*/
//    private Integer constantErrors;
//    /** 登录错误的日期。*/
//    private LocalDate errorDate;
//    /** 登录错误时的登录IP。*/
//    private String errorLoginIp;

    // private String loginMode;

    public UserLoginHistory() {
        super();
        loginCount = 0;
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

    public UserDevice getDevice() {
        return device;
    }

    public void setDevice(UserDevice device) {
        this.device = device;
    }

    public String getLoginField() {
        return loginField;
    }

    public void setLoginField(String loginField) {
        this.loginField = loginField;
    }

    /**
     * 最后一次登录的{@code User-Agent} 信息，设备不同，该信息格式也不同。
     */
    public String getLastUserAgent() {
        return lastUserAgent;
    }

    public void setLastUserAgent(String lastUserAgent) {
        this.lastUserAgent = lastUserAgent;
    }

    /**
     * 前一次登录的{@code User-Agent} 信息，设备不同，该信息格式也不同。
     */
    public String getPrevUserAgent() {
        return prevUserAgent;
    }

    public void setPrevUserAgent(String prevUserAgent) {
        this.prevUserAgent = prevUserAgent;
    }

    public DateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(DateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public DateTime getPrevLoginTime() {
        return prevLoginTime;
    }

    public void setPrevLoginTime(DateTime prevLoginTime) {
        this.prevLoginTime = prevLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getPrevLoginIp() {
        return prevLoginIp;
    }

    public void setPrevLoginIp(String prevLoginIp) {
        this.prevLoginIp = prevLoginIp;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 最后一次登录的{@code token}，如果是浏览器，表示为{@code session id}。
     */
    public String getLastToken() {
        return lastToken;
    }

    public void setLastToken(String lastToken) {
        this.lastToken = lastToken;
    }

    /**
     * 前一次登录的{@code token}，如果是浏览器，表示为{@code session id}。
     */
    public String getPrevToken() {
        return prevToken;
    }

    public void setPrevToken(String prevToken) {
        this.prevToken = prevToken;
    }

//    /**
//     * 总计的登录错误次数。
//     */
//    public Integer getTotalErrors() {
//        return totalErrors;
//    }
//
//    public void setTotalErrors(Integer totalErrors) {
//        this.totalErrors = totalErrors;
//    }
//
//    /**
//     * 会话内的登录错误次数。
//     */
//    public Integer getConstantErrors() {
//        return constantErrors;
//    }
//
//    public void setConstantErrors(Integer constantErrors) {
//        this.constantErrors = constantErrors;
//    }
//
//    /**
//     * 登录错误的日期。
//     */
//    public LocalDate getErrorDate() {
//        return errorDate;
//    }
//
//    public void setErrorDate(LocalDate errorDate) {
//        this.errorDate = errorDate;
//    }
//
//    /**
//     * 登录错误时的登录IP。
//     */
//    public String getErrorLoginIp() {
//        return errorLoginIp;
//    }
//
//    public void setErrorLoginIp(String errorLoginIp) {
//        this.errorLoginIp = errorLoginIp;
//    }

    // logical method
    // ----------------------------------------------------------------------------------

    public UserLoginHistory updateHistory(
            String loginField, String loginIp, String userAgent,
            DateTime loginTime, String token) {
        setLoginField(loginField);
        final DateTime llt = getLastLoginTime();
        if (llt.getYear() != loginTime.getYear() ||
                llt.getMonthOfYear() != loginTime.getMonthOfYear() ||
                llt.getDayOfMonth() != loginTime.getDayOfMonth()) {
            // is not same day
            setPrevLoginIp(getLastLoginIp());
            setPrevLoginTime(getLastLoginTime());
            setPrevToken(getLastToken());
            setPrevUserAgent(getLastUserAgent());
        }
        setLastLoginIp(loginIp);
        setLastLoginTime(loginTime);
        setLastToken(token);
        setLastUserAgent(userAgent);
        setLoginCount(getLoginCount() + 1);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o == this) {
            return true;
        } else if (!(o instanceof UserLoginHistory)) {
            return false;
        }
        UserLoginHistory that = (UserLoginHistory) o;

        if (getId() != null) {
            return that.getId() != null && getId().equals(that.getId());
        } else {
            if (that.getId() != null) {
                return false;
            }
            if (getDevice() == that.getDevice() &&
                    Objects.equals(getUserId(), that.getUserId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (lastUserAgent != null ? lastUserAgent.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
        result = 31 * result + (lastToken != null ? lastToken.hashCode() : 0);
        result = 31 * result + (prevUserAgent != null ? prevUserAgent.hashCode() : 0);
        result = 31 * result + (prevLoginTime != null ? prevLoginTime.hashCode() : 0);
        result = 31 * result + (prevLoginIp != null ? prevLoginIp.hashCode() : 0);
        result = 31 * result + (prevToken != null ? prevToken.hashCode() : 0);
        result = 31 * result + (loginCount != null ? loginCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_USER_NAME, getUserName())
                .add(PROP_DEVICE, getDevice())
                .add(PROP_LOGIN_FIELD, getLoginField())
                .add(PROP_LOGIN_COUNT, getLoginCount())
                .add(PROP_LAST_LOGIN_TIME, getLastLoginTime())
                .add(PROP_PREV_LOGIN_TIME, getPrevLoginTime())
                .add(PROP_LAST_LOGIN_IP, getLastLoginIp())
                .add(PROP_PREV_LOGIN_IP, getPrevLoginIp())
                .add(PROP_LAST_TOKEN, getLastToken())
                .add(PROP_PREV_TOKEN, getPrevToken())
                .add(PROP_LAST_USER_AGENT, getLastUserAgent())
                .add(PROP_PREV_USER_AGENT, getPrevUserAgent())
//                .add(PROP_TOTAL_ERRORS, getTotalErrors())
//                .add(PROP_CONSTANT_ERROrs, getConstantErrors())
//                .add(PROP_ERROR_DATE, getErrorDate())
//                .add(PROP_ERROR_LOGIN_IP, getErrorLoginIp())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
