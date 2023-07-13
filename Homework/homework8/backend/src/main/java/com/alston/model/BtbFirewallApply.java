package com.alston.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "btb_firewall_apply", schema = "firewall")
public class BtbFirewallApply {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NO")
    private int no;
    @Basic
    @Column(name = "CASE_NO")
    private String caseNo;
    @Basic
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Basic
    @Column(name = "SERVICE_CASE_NO")
    private int serviceCaseNo;
    @Basic
    @Column(name = "BAN")
    private String ban;
    @Basic
    @Column(name = "APPLY")
    private String apply;
    @Basic
    @Column(name = "APPLY_DATE")
    private Instant applyDate;
    @Basic
    @Column(name = "APPROVED")
    private String approved;
    @Basic
    @Column(name = "APPROVED_DATE")
    private Instant approvedDate;
    @Basic
    @Column(name = "STATUS")
    private String status;
    @Basic
    @Column(name = "REMARK")
    private String remark;
    @Basic
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic
    @Column(name = "CREATED_DATE")
    private Instant createdDate;
    @Basic
    @Column(name = "CREATED_IP")
    private String createdIp;
    @Basic
    @Column(name = "CREATED_FUNC")
    private String createdFunc;
    @Basic
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;
    @Basic
    @Column(name = "LAST_MODIFIED_DATE")
    private Instant lastModifiedDate;
    @Basic
    @Column(name = "LAST_MODIFIED_IP")
    private String lastModifiedIp;
    @Basic
    @Column(name = "LAST_MODIFIED_FUNC")
    private String lastModifiedFunc;

    public BtbFirewallApply() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceCaseNo() {
        return serviceCaseNo;
    }

    public void setServiceCaseNo(int serviceCaseNo) {
        this.serviceCaseNo = serviceCaseNo;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Instant applyDate) {
        this.applyDate = applyDate;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public Instant getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Instant approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedIp() {
        return createdIp;
    }

    public void setCreatedIp(String createdIp) {
        this.createdIp = createdIp;
    }

    public String getCreatedFunc() {
        return createdFunc;
    }

    public void setCreatedFunc(String createdFunc) {
        this.createdFunc = createdFunc;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedIp() {
        return lastModifiedIp;
    }

    public void setLastModifiedIp(String lastModifiedIp) {
        this.lastModifiedIp = lastModifiedIp;
    }

    public String getLastModifiedFunc() {
        return lastModifiedFunc;
    }

    public void setLastModifiedFunc(String lastModifiedFunc) {
        this.lastModifiedFunc = lastModifiedFunc;
    }

}