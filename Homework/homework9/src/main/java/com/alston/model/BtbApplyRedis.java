package com.alston.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.Instant;

@RedisHash
public class BtbApplyRedis implements Serializable {

    private String redisKey;

    @Id
    private int no;
    private String caseNo;
    private String serviceName;
    private int serviceCaseNo;
    private String ban;
    private String apply;
    private Instant applyDate;
    private String approved;
    private Instant approvedDate;
    private String status;
    private String remark;
    private String createdBy;
    private Instant createdDate;
    private String createdIp;
    private String createdFunc;
    private String lastModifiedBy;
    private Instant lastModifiedDate;
    private String lastModifiedIp;
    private String lastModifiedFunc;

    public BtbApplyRedis() {
    }

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String keyStr) {
        this.redisKey = "Apply_"+keyStr;
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