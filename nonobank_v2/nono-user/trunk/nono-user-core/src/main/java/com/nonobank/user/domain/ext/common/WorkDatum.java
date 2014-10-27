/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) WorkDatum.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext.common;

import java.io.Serializable;

/**
 * 用户工作单位信息
 *
 * @author Yichuan
 * @version $Id: WorkDatum.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class WorkDatum implements Serializable {

    private static final long serialVersionUID = 4171630926948753632L;

    // 工作单位名称
    private String compName;
    // 工作单位性质
    private String compNature;
    // 工作单位所属行业
    private String industry;
    // 工作单位担当职位
    private String position;
    // 当前单位入职年
    private Integer entryYear;
    // 当前单位入职月
    private Integer entryMonth;
    // 工龄
    private String seniority;
    // 工作单位电话
    private String compPhone;
    // 工作单位地址
    private String compAddress;
    // 单位所属部门
    private String department;
    // 单位备注
    private String remarks;

    public WorkDatum() {
        super();
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompNature() {
        return compNature;
    }

    public void setCompNature(String compNature) {
        this.compNature = compNature;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(Integer entryYear) {
        this.entryYear = entryYear;
    }

    public Integer getEntryMonth() {
        return entryMonth;
    }

    public void setEntryMonth(Integer entryMonth) {
        this.entryMonth = entryMonth;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getCompPhone() {
        return compPhone;
    }

    public void setCompPhone(String compPhone) {
        this.compPhone = compPhone;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
