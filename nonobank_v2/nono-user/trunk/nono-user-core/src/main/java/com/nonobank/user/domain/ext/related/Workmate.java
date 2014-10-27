/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) Workmate.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext.related;

import java.io.Serializable;
import java.util.Objects;

/**
 * 同事关系实体
 *
 * @author Yichuan
 * @version $Id: Workmate.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class Workmate implements Serializable {

    private static final long serialVersionUID = 3725934917566399461L;

    // 同事姓名
    private String name;
    // 职位
    private String position;
    // 联系电话
    private String contact;

    public Workmate() {
        super();
    }

    public Workmate(String name, String position, String contact) {
        this.name = name;
        this.position = position;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workmate)) return false;

        Workmate that = (Workmate) o;

        return Objects.equals(contact, that.contact) &&
                Objects.equals(name, that.name) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Workmate{name='%s', position='%s', contact='%s'}",
                name, position, contact);
    }
}
