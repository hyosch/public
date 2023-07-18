package com.alston.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BtbIpType {

    @Id
    private int no;
    private String type;
    private String ban;
    private String status;
    private String cont_email;

    public BtbIpType() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public String getCont_email() {
        return cont_email;
    }

    public void setCont_email(String cont_email) {
        this.cont_email = cont_email;
    }

}