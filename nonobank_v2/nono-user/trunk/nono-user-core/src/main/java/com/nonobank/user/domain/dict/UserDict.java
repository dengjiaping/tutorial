/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserDict.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

import com.google.common.collect.ImmutableList;
import org.springframework.data.domain.Sort;

import static com.nonobank.user.domain.ctx.DictCmdContext.commonDictRepository;

/**
 * @author fuchun
 * @version $Id: UserDict.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public abstract class UserDict {
    private UserDict() {}

    /**
     * marriage 属性的类型关键字。
     */
    public static final String MARRIAGE = "marriage";
    public static final String EDUCATION = "education";
    public static final String POSITION = "position";
    public static final String SKILL_CERT = "skillCert";

    public static Dict getMarriage(String code) {
        return commonDictRepository().findByTypeKeyAndCode(MARRIAGE, code);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Dict> ImmutableList<T> findMarriages(Sort sort) {
        return (ImmutableList<T>) commonDictRepository().findByTypeKey(MARRIAGE, sort);
    }

    public static Dict getEducation(String code) {
        return commonDictRepository().findByTypeKeyAndCode(EDUCATION, code);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Dict> ImmutableList<T> findEducations(Sort sort) {
        return (ImmutableList<T>) commonDictRepository().findByTypeKey(EDUCATION, sort);
    }

    public static Dict getPosition(String code) {
        return commonDictRepository().findByTypeKeyAndCode(POSITION, code);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Dict> ImmutableList<T> findPositions(Sort sort) {
        return (ImmutableList<T>) commonDictRepository().findByTypeKey(POSITION, sort);
    }

    public static Dict getSkillCert(String code) {
        return commonDictRepository().findByTypeKeyAndCode(SKILL_CERT, code);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Dict> ImmutableList<T> findSkillCerts(Sort sort) {
        return (ImmutableList<T>) commonDictRepository().findByTypeKey(SKILL_CERT, sort);
    }
}
