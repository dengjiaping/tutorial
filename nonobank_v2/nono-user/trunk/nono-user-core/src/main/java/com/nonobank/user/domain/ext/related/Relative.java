/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) Relative.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext.related;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * 亲属信息
 *
 * @author Yichuan
 * @version $Id: Relative.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class Relative implements Serializable {

    private static final long serialVersionUID = -4612400079550565748L;

    // 亲属姓名
    private String name;
    // 与本人的关系
    private String relation;
    // 亲属工作的单位
    private String company;
    // 联系电话
    private String contact;
    // 备注
    private String remarks;

    public Relative() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Relative)) return false;

        Relative relative = (Relative) o;

        if (company != null ? !company.equals(relative.company) : relative.company != null) return false;
        if (contact != null ? !contact.equals(relative.contact) : relative.contact != null) return false;
        if (name != null ? !name.equals(relative.name) : relative.name != null) return false;
        if (relation != null ? !relation.equals(relative.relation) : relative.relation != null) return false;
        if (remarks != null ? !remarks.equals(relative.remarks) : relative.remarks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (relation != null ? relation.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", getName())
                .add("relation", getRelation())
                .add("company", getCompany())
                .add("contact", getContact())
                .add("remarks", getRemarks())
                .toString();
    }
}
