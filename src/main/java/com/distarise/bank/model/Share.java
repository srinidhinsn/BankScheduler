package com.distarise.bank.model;

public class Share {
    private String cno;
    private String acctNo;
    private String bal;
    private String st_dot;
    private String st_part;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getBal() {
        return bal;
    }

    public void setBal(String bal) {
        this.bal = bal;
    }

    public String getSt_dot() {
        return st_dot;
    }

    public void setSt_dot(String st_dot) {
        this.st_dot = st_dot;
    }

    public String getSt_part() {
        return st_part;
    }

    public void setSt_part(String st_part) {
        this.st_part = st_part;
    }
}
