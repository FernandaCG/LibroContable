package com.nearsoft.academy.ledger.Entity;

import java.util.Date;

public class Transaction{
    private Date date;
    private String account;
    private String aubaccount;
    private Float amount;
    private String currency;

    public Transaction(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAubaccount() {
        return aubaccount;
    }

    public void setAubaccount(String aubaccount) {
        this.aubaccount = aubaccount;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}