package com.alston.dto;

public class UpdateParam {

    private int[] noArray;
    private String status;
    private String remark;
    private String account;
    private String ip;

    public UpdateParam() {
    }

    public int[] getNoArray() {
        return noArray;
    }

    public void setNoArray(int[] noArray) {
        this.noArray = noArray;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}