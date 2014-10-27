/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) Bank.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractEntity;
import com.nonobank.user.domain.ctx.DictCmdContext;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

/**
 * 银行数据字典实体类。
 *
 * @author fuchun
 * @version $Id: Bank.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class Bank extends AbstractEntity<Integer, Bank> {

    public static final String PROP_LOC_CODE = "locCode";
    public static final String PROP_PARENT_ID = "parentId";

    private static final long serialVersionUID = 8370407027835629688L;

    /**
     * 获取所有银行顶层信息列表。
     * <pre>
     * 中国工商银行
     * 中国农业银行
     * 中国银行
     * ……
     * </pre>
     */
    @Nonnull
    public static List<Bank> listTopBanks() {
        return DictCmdContext.bankRepository().findByParentIdNull(null);
    }

    /**
     * 获取指定银行id和城市（省）代码的所有分（支）行信息列表。
     * <pre>{@code
     * bankId == null || bankId <= 0    ---&gt;    []
     * cityCode == null || cityCode <= 0 --&gt;    []
     * <p>
     * // 获取上海市所有的工商银行分（支）行信息
     * List<Bank> banks = Bank.listBranches(1, 310000);
     * }</pre>
     *
     * @param bankId   银行Id。
     * @param cityCode 城市（省）代码。
     * @return 返回指定银行id和城市（省）代码的所有分（支）行信息列表。
     */
    @Nonnull
    public static List<Bank> listBranches(Integer bankId, Integer cityCode) {
        if (bankId == null || bankId <= 0 ||
                cityCode == null || cityCode <= 0) {
            return Collections.emptyList();
        }
        return DictCmdContext.bankRepository()
                .findByLocCodeAndParentId(cityCode, bankId, null);
    }

    public static Bank of(Integer id, String name, Integer locCode, Integer parentId) {
        Bank bank = new Bank(id);
        bank.setName(name);
        bank.setLocCode(locCode);
        bank.setParentId(parentId);
        return bank;
    }

    private String name;
    private Integer locCode;
    private Integer parentId;

    private Location location;
    private Bank parent;

    public Bank() {
        super();
    }

    public Bank(Integer id) {
        setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocCode() {
        return locCode;
    }

    public void setLocCode(Integer locCode) {
        this.locCode = locCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Bank getParent() {
        return parent;
    }

    public void setParent(Bank parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;
        if (!super.equals(o)) return false;

        Bank bank = (Bank) o;

        if (locCode != null ? !locCode.equals(bank.locCode) : bank.locCode != null) return false;
        if (location != null ? !location.equals(bank.location) : bank.location != null) return false;
        if (name != null ? !name.equals(bank.name) : bank.name != null) return false;
        if (parentId != null ? !parentId.equals(bank.parentId) : bank.parentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (locCode != null ? locCode.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_ID, getId())
                .add(PROP_NAME, getName())
                .add(PROP_LOC_CODE, getLocCode())
                .add(PROP_PARENT_ID, getParentId())
                .toString();
    }
}
