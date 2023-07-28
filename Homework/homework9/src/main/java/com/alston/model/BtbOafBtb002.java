package com.alston.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "btb_oaf_btb002", schema = "firewall")
public class BtbOafBtb002 {

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
    @Column(name = "ROUT_ID")
    private String routId;
    @Basic
    @Column(name = "CHECKLIST_EMAIL")
    private String checklistEmail;
    @Basic
    @Column(name = "TEST_BEGIN_DATE")
    private Instant testBeginDate;
    @Basic
    @Column(name = "TEST_END_DATE")
    private Instant testEndDate;
    @Basic
    @Column(name = "REMARK")
    private String remark;
    @Basic
    @Column(name = "OID")
    private String oid;
    @Basic
    @Column(name = "TKVER_INV_YM")
    private String tkverInvYm;
    @Basic
    @Column(name = "TKVER_INV_TRACK")
    private String tkverInvTrack;
    @Basic
    @Column(name = "TKVER_INV_BEGIN_NO")
    private String tkverInvBeginNo;
    @Basic
    @Column(name = "TKVER_INV_END_NO")
    private String tkverInvEndNo;
    @Basic
    @Column(name = "OAF_ID")
    private String oafId;
    @Basic
    @Column(name = "IS_CROSS")
    private String isCross;
    @Basic
    @Column(name = "IS_CERT")
    private String isCert;
    @Basic
    @Column(name = "IS_IMPORT")
    private String isImport;
    @Basic
    @Column(name = "AGREE_OID_APPLY")
    private String agreeOidApply;
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

    public BtbOafBtb002() {
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

    public String getRoutId() {
        return routId;
    }

    public void setRoutId(String routId) {
        this.routId = routId;
    }

    public String getChecklistEmail() {
        return checklistEmail;
    }

    public void setChecklistEmail(String checklistEmail) {
        this.checklistEmail = checklistEmail;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTkverInvYm() {
        return tkverInvYm;
    }

    public void setTkverInvYm(String tkverInvYm) {
        this.tkverInvYm = tkverInvYm;
    }

    public String getTkverInvTrack() {
        return tkverInvTrack;
    }

    public void setTkverInvTrack(String tkverInvTrack) {
        this.tkverInvTrack = tkverInvTrack;
    }

    public String getTkverInvBeginNo() {
        return tkverInvBeginNo;
    }

    public void setTkverInvBeginNo(String tkverInvBeginNo) {
        this.tkverInvBeginNo = tkverInvBeginNo;
    }

    public String getTkverInvEndNo() {
        return tkverInvEndNo;
    }

    public void setTkverInvEndNo(String tkverInvEndNo) {
        this.tkverInvEndNo = tkverInvEndNo;
    }

    public String getOafId() {
        return oafId;
    }

    public void setOafId(String oafId) {
        this.oafId = oafId;
    }

    public String getIsCross() {
        return isCross;
    }

    public void setIsCross(String isCross) {
        this.isCross = isCross;
    }

    public String getIsCert() {
        return isCert;
    }

    public void setIsCert(String isCert) {
        this.isCert = isCert;
    }

    public String getAgreeOidApply() {
        return agreeOidApply;
    }

    public void setAgreeOidApply(String agreeOidApply) {
        this.agreeOidApply = agreeOidApply;
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