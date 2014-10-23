/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Assets.java 2014-10-11 13:49
 */

package com.nonobank.user.domain.ext.related;

import com.google.common.collect.Lists;
import com.nonobank.common.base.EnumValue;

import java.util.List;

/**
 * 资产类型枚举
 *
 * @author Yichuan
 * @version $Id: Assets.java 144 2014-10-13 08:09:26Z yichuan $
 * @since 2.0
 */
public enum Assets implements EnumValue<Short> {

    /**
     * 房产
     */
    HOUSE(2, "房产", "house"),

    /**
     * 车产
     */
    CAR(3, "车产", "car"),

    /**
     * 股票
     */
    STOCK(5, "股票", "stock"),

    /**
     * 基金
     */
    FUND(7, "基金", "fund"),

    /**
     * 商铺
     */
    SHOPS(11, "商铺", "shops"),

    /**
     * 其他
     */
    OTHER(13, "其他", "other");

    // code值只能是质数(素数)
    final short code;
    final String name;
    final String alias;

    private Assets(int code, String name, String alias) {
        this.code = (short)code;
        this.name = name;
        this.alias = alias;
    }

    public short getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Short getValue() {
        return code;
    }

    /**
     * 返回指定标识的 {@link Assets} 枚举对象，如果标识为 {@code null}，
     * 或者不存在，则返回 {@link null}。
     *
     * @param code 标识。
     * @param <N>  标识的类型。
     * @return 返回指定标识的 {@link Assets} 枚举对象。
     */
    public static <N extends Number> Assets of(N code) {
        if (code == null) {
            return null;
        }
        for (Assets e : values()) {
            if (e.code == code.shortValue()) {
                return e;
            }
        }
        return null;
    }

    /**
     * 根据提供的资产编号计算出数据库中存放的值
     */
    public static Integer count(List<Integer> list) {
        if (list.isEmpty()) return null;
        Integer result = null;
        for (Assets a: values()) {
            if (list.contains((int)a.code)) {
                result = result == null ? a.code : result * a.code;
            }
        }
        return result;
    }

    /**
     * 将数据库中保存的资产值转换为资产数据
     */
    public static List<Assets> convert(Integer val) {
        List<Assets> result = Lists.newArrayList();
        if (val != null) {
            for (Assets a : values()) if (val % a.code == 0) result.add(a);
        }
        return result;
    }
}