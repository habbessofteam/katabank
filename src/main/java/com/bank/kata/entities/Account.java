package com.bank.kata.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Account {
    private double id;
    private BigDecimal solde;
    private Client client;
    private BigDecimal overDraftAmount;
    private ArrayList<Transaction> transactions;

    public Account() {
        this.id = (Double) Math.random() * 123 + 1;
    }

    public Account(BigDecimal solde, BigDecimal overDraftAmount) {
        this.id = (Double) Math.random() * 123 + 1;
        this.solde = solde;
        this.overDraftAmount = overDraftAmount;
        this.initTransactions();
    }

    public double getId() {
        return id;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getOverDraftAmount() {
        return overDraftAmount;
    }

    public void setOverDraftAmount(BigDecimal overDreaftAmount) {
        this.overDraftAmount = overDreaftAmount;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void initTransactions(){
        this.transactions = new ArrayList<Transaction>();
    }
}
