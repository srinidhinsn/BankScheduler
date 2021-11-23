package com.distarise.bank.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Customer implements Serializable {
        private String cno;
        private String firstName;
        private String lastName;
        private String type;
        private List<Share> shares;
        private Map<String, List<SavingBank>> savingBanks;
        private Map<String, Map<String, List<RemainingAcct>>> remainingAcctMap;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public Map<String, List<SavingBank>> getSavingBanks() {
        return savingBanks;
    }

    public void setSavingBanks(Map<String, List<SavingBank>> savingBanks) {
        this.savingBanks = savingBanks;
    }

    public Map<String, Map<String, List<RemainingAcct>>> getRemainingAcctMap() {
        return remainingAcctMap;
    }

    public void setRemainingAcctMap(Map<String, Map<String, List<RemainingAcct>>> remainingAcctMap) {
        this.remainingAcctMap = remainingAcctMap;
    }
}
