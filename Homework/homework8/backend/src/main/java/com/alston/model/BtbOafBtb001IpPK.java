package com.alston.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BtbOafBtb001IpPK implements Serializable {

    @Column(name = "APPLY_NO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applyNo;
    @Column(name = "APPLY_SEQ")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applySeq;

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

}