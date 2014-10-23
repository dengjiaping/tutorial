/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) College.java 2014-10-13 16:50
 */

package com.nonobank.user.domain.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractEntity;
import com.nonobank.user.domain.ctx.DictCmdContext;
import org.springframework.data.domain.Sort;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 中国一级、二级学院信息实体。
 *
 * @author fuchun
 * @version $Id: College.java 198 2014-10-17 02:35:50Z fuchun $
 * @since 2.0
 */
public class College extends AbstractEntity<Integer, College> {

    public static final String PROP_NAME_CRC = "nameCrc";
    public static final String PROP_STATE_CODE = "stateCode";
    public static final String PROP_GRADE = "grade";
    public static final String PROP_ENABLED = "enabled";

    private static final long serialVersionUID = 1019601583535303592L;

    /**
     * 获取指定名称的学院信息。
     *
     * @param name 学院名称。
     * @return 返回指定名称的学院信息。
     */
    public static College get(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        return DictCmdContext.collegeRepository().findByName(name);
    }

    /**
     * 获取指定省（州）代码的全部学院信息。
     * <p />
     * 此调用会返回所有的（包括{@code isEnabled() == true} ）的信息，可以调用以下方式进行过滤：
     * <pre>{@code
     * College.list(310000, null).stream()
     *         .filter(c -> c.isEnabled())
     *         .collect(Collectors.toList());
     * }</pre>
     *
     * @param stateCode 省（州）代码。
     * @param sort 排序规则。
     * @return 返回指定省（州）代码的全部学院信息。
     */
    @Nonnull
    public static List<College> list(Integer stateCode, Sort sort) {
        if (stateCode == null || stateCode <= 0) {
            return Collections.emptyList();
        }
        return DictCmdContext.collegeRepository().findByStateCode(stateCode, sort);
    }

    private String name;
    private Long nameSrc;
    private Integer stateCode;
    private Short grade;
    private boolean isEnabled;

    private State state;

    public College() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNameSrc() {
        return nameSrc;
    }

    public void setNameSrc(Long nameSrc) {
        this.nameSrc = nameSrc;
    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @JsonIgnore
    public State getState() {
        if (state == null) {
            state = Optional.ofNullable(Location.getState(getStateCode()))
                    .orElse(State.EMPTY_STATE);
        }
        return state == State.EMPTY_STATE ? null : state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_ID, getId())
                .add(PROP_NAME, getName())
                .add(PROP_NAME_CRC, getNameSrc())
                .add(PROP_STATE_CODE, getStateCode())
                .add(PROP_GRADE, getGrade())
                .add(PROP_ENABLED, isEnabled())
                .toString();
    }
}