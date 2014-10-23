/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CollegeDTO.java 2014-10-21 13:21
 */

package com.nonobank.user.facade.dto.dict;

import java.io.Serializable;

/**
 * The DTO of the {@code College}.
 *
 * @author fuchun
 * @version $Id: CollegeDTO.java 233 2014-10-21 09:13:58Z fuchun $
 * @since 2.0
 */
public class CollegeDTO implements Serializable {

    private static final long serialVersionUID = 6726400525952690418L;

    private final Integer id;
    private final String name;
    private final StateDTO state;
    private final Short grade;

    public CollegeDTO(Integer id, String name, StateDTO state, Short grade) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StateDTO getState() {
        return state;
    }

    public Short getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("CollegeDTO{id=%s, name=%s, state=%s, grade=%s}",
                getId(), getName(), getState(), getGrade());
    }
}
