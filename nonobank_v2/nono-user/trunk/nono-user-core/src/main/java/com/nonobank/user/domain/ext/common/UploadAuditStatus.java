/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UploadAuditStatus.java 2014-10-20 17:11
 */

package com.nonobank.user.domain.ext.common;

import com.nonobank.common.base.EnumValue;

/**
 * 文件上传审核状态枚举
 *
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public enum UploadAuditStatus implements EnumValue<Integer> {

    /**
     * 等待审核/未审核
     */
    WAITING(0, "等待审核"),

    /**
     * 审核通过
     */
    AUDIT_PASS(1, "审核通过"),

    /**
     * 审核拒绝
     */
    AUDIT_REFUSE(2, "审核拒绝"),

    /**
     * 分审通过
     */
    FIRST_PASS(11, "分审通过"),

    /**
     * 分审拒绝
     */
    FIRST_REFUSE(12, "分审拒绝"),

    /**
     * 终审通过
     */
    FINAL_PASS(13, "终审通过"),

    /**
     * 终审拒绝
     */
    FINAL_REFUSE(14, "终审拒绝");


    final short code;
    final String name;

    private UploadAuditStatus(int code, java.lang.String name) {
        this.code = (short)code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public short getCode() {
        return code;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Integer getValue() {
        return (int)code;
    }

    /**
     * 用户身份上传审核时的状态
     */
    public static UploadAuditStatus[] normal() {
        return new UploadAuditStatus[] {
                WAITING, AUDIT_PASS, AUDIT_REFUSE
        };
    }

    /**
     * 用户其他上传审核时的状态
     */
    public static UploadAuditStatus[] multistep() {
        return new UploadAuditStatus[] {
                WAITING, FIRST_PASS, FIRST_REFUSE, FINAL_PASS, FINAL_REFUSE
        };
    }

    /**
     * 返回指定标识的 {@link UploadAuditStatus} 枚举对象，如果标识为 {@code null}，
     * 或者不存在，则返回 {@link null}。
     *
     * @param code 标识。
     * @param <N>  标识的类型。
     * @return 返回指定标识的 {@link UploadAuditStatus} 枚举对象。
     */
    public static <N extends Number> UploadAuditStatus of(N code) {
        if (code == null) {
            return null;
        }
        for (UploadAuditStatus e : values()) {
            if (e.code == code.shortValue()) {
                return e;
            }
        }
        return null;
    }
}