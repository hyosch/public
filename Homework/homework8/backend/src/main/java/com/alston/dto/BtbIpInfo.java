package com.alston.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class BtbIpInfo {

    @Id
    private Integer no;
    private Instant applyDate;
    private String status;
    private String ban;
    private Instant approvedDate;

    public BtbIpInfo() {
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Instant applyDate) {
        this.applyDate = applyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public Instant getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Instant approvedDate) {
        this.approvedDate = approvedDate;
    }

}