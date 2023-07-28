package com.alston.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "btb_oaf_btb001_ip", schema = "firewall")
@IdClass(BtbOafBtb001IpPK.class)
public class BtbOafBtb001Ip implements Serializable {

    private String redisKey;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "APPLY_NO")
    private Integer applyNo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "APPLY_SEQ")
    private Integer applySeq;
    @Basic
    @Column(name = "TYPE")
    private String type;
    @Basic
    @Column(name = "SERVICE")
    private String service;
    @Basic
    @Column(name = "IP_ADDRESS")
    private String ipAddress;
    @Basic
    @Column(name = "CARD_CODE")
    private String cardCode;
    @Basic
    @Column(name = "ROUT_ID")
    private String routId;
    @Basic
    @Column(name = "SEQ")
    private Integer seq;
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

    public BtbOafBtb001Ip() {
    }

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String keyStr) {
        this.redisKey = "oafSM_" + keyStr;
    }

    public int getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(int applyNo) {
        this.applyNo = applyNo;
    }

    public int getApplySeq() {
        return applySeq;
    }

    public void setApplySeq(int applySeq) {
        this.applySeq = applySeq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getRoutId() {
        return routId;
    }

    public void setRoutId(String routId) {
        this.routId = routId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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

    @Override
    public String toString() {
        return "BtbOafBtb001Ip{" +
                "redisKey='" + redisKey + '\'' +
                ", applyNo=" + applyNo +
                ", applySeq=" + applySeq +
                ", type='" + type + '\'' +
                ", service='" + service + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", cardCode='" + cardCode + '\'' +
                '}';
    }
}