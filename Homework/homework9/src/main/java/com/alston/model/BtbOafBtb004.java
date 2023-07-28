package com.alston.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "btb_oaf_btb004", schema = "firewall")
public class BtbOafBtb004 {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NO")
    private int no;
    @Basic
    @Column(name = "CASE_NO")
    private String caseNo;
    @Basic
    @Column(name = "TYPE")
    private String type;
    @Basic
    @Column(name = "BAN")
    private String ban;
    @Basic
    @Column(name = "STATUS")
    private String status;
    @Basic
    @Column(name = "APPLY_DATE")
    private Instant applyDate;
    @Basic
    @Column(name = "APPROVED_DATE")
    private Instant approvedDate;
    @Basic
    @Column(name = "APPROVED")
    private String approved;
    @Basic
    @Column(name = "CONT_NAME")
    private String contName;
    @Basic
    @Column(name = "CONT_TEL")
    private String contTel;
    @Basic
    @Column(name = "CONT_EMAIL")
    private String contEmail;
    @Basic
    @Column(name = "CONT_ADDR")
    private String contAddr;
    @Basic
    @Column(name = "CARD_CODE")
    private String cardCode;
    @Basic
    @Column(name = "CARD_NAME")
    private String cardName;
    @Basic
    @Column(name = "TEST_BEGIN_DATE")
    private Instant testBeginDate;
    @Basic
    @Column(name = "TEST_END_DATE")
    private Instant testEndDate;
    @Basic
    @Column(name = "O_VER_TOKEN_URL")
    private String oVerTokenUrl;
    @Basic
    @Column(name = "O_PRO_TOKEN_URL")
    private String oProTokenUrl;
    @Basic
    @Column(name = "N_VER_TOKEN_URL")
    private String nVerTokenUrl;
    @Basic
    @Column(name = "N_PRO_TOKEN_URL")
    private String nProTokenUrl;
    @Basic
    @Column(name = "N_MEMBER_CARD_KEY")
    private String nMemberCardKey;
    @Basic
    @Column(name = "N_IS_ENC_MEM_SAME")
    private String nIsEncMemSame;
    @Basic
    @Column(name = "REMARK")
    private String remark;
    @Basic
    @Column(name = "OAF_ID")
    private String oafId;
    @Basic
    @Column(name = "IS_CERT")
    private String isCert;
    @Basic
    @Column(name = "IS_IMPORT")
    private String isImport;
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
    @Basic
    @Column(name = "CONT_TEL_EXT")
    private String contTelExt;

    public BtbOafBtb004() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Instant applyDate) {
        this.applyDate = applyDate;
    }

    public Instant getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Instant approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getContEmail() {
        return contEmail;
    }

    public void setContEmail(String contEmail) {
        this.contEmail = contEmail;
    }

    public String getContAddr() {
        return contAddr;
    }

    public void setContAddr(String contAddr) {
        this.contAddr = contAddr;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Instant getTestBeginDate() {
        return testBeginDate;
    }

    public void setTestBeginDate(Instant testBeginDate) {
        this.testBeginDate = testBeginDate;
    }

    public Instant getTestEndDate() {
        return testEndDate;
    }

    public void setTestEndDate(Instant testEndDate) {
        this.testEndDate = testEndDate;
    }

    public String getoVerTokenUrl() {
        return oVerTokenUrl;
    }

    public void setoVerTokenUrl(String oVerTokenUrl) {
        this.oVerTokenUrl = oVerTokenUrl;
    }

    public String getoProTokenUrl() {
        return oProTokenUrl;
    }

    public void setoProTokenUrl(String oProTokenUrl) {
        this.oProTokenUrl = oProTokenUrl;
    }

    public String getnVerTokenUrl() {
        return nVerTokenUrl;
    }

    public void setnVerTokenUrl(String nVerTokenUrl) {
        this.nVerTokenUrl = nVerTokenUrl;
    }

    public String getnProTokenUrl() {
        return nProTokenUrl;
    }

    public void setnProTokenUrl(String nProTokenUrl) {
        this.nProTokenUrl = nProTokenUrl;
    }

    public String getnMemberCardKey() {
        return nMemberCardKey;
    }

    public void setnMemberCardKey(String nMemberCardKey) {
        this.nMemberCardKey = nMemberCardKey;
    }

    public String getnIsEncMemSame() {
        return nIsEncMemSame;
    }

    public void setnIsEncMemSame(String nIsEncMemSame) {
        this.nIsEncMemSame = nIsEncMemSame;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOafId() {
        return oafId;
    }

    public void setOafId(String oafId) {
        this.oafId = oafId;
    }

    public String getIsCert() {
        return isCert;
    }

    public void setIsCert(String isCert) {
        this.isCert = isCert;
    }

    public String getIsImport() {
        return isImport;
    }

    public void setIsImport(String isImport) {
        this.isImport = isImport;
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

    public String getContTelExt() {
        return contTelExt;
    }

    public void setContTelExt(String contTelExt) {
        this.contTelExt = contTelExt;
    }

}