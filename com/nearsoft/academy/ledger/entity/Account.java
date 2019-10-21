package com.nearsoft.academy.ledger.entity;

public class Account{

    private String account;
    private String subaccount;
    private String amount;
    private String currency;

    public Account() {
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", subaccount='" + subaccount + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSubaccount() {
        return subaccount;
    }

    public void setSubaccount(String subaccount) {
        this.subaccount = subaccount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}