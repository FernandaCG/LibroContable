package com.nearsoft.academy.ledger.entity;

import java.util.Date;
import java.util.ArrayList;

import com.nearsoft.academy.ledger.entity.Account;

public class Transaction{
    private String date;
    private String description;
    private Account[] accounts = new Account[2];


    public Transaction(){

    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", accounts=" + java.util.Arrays.toString(accounts) +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}