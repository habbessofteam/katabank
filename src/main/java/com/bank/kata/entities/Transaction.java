package com.bank.kata.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    final String TRANSACTION_DEPOSIT = "DEPOSIT";
    final String TRANSACTION_WITHDRAWAL = "WITHDRAWAL";


    private Double id;
    private Date transactionDate;
    private BigDecimal amount;
    private BigDecimal balanceBeforeTransaction;
    private String transactionType;
    private Account account;

    public Transaction() {
        this.id = (Double) Math.random() * 123 + 1;
    }

    public Transaction( Date transactionDate, BigDecimal amount, BigDecimal balanceBeforeTransaction, String transactionType) {
        this.id = (Double) Math.random() * 123 + 1;        this.transactionDate = transactionDate;
        this.amount = amount;
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        this.transactionType = transactionType;
    }

    public Double getId() {
        return id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalanceBeforeTransaction() {
        return balanceBeforeTransaction;
    }

    public void setBalanceBeforeTransaction(BigDecimal balanceBeforeTransaction) {
        this.balanceBeforeTransaction = balanceBeforeTransaction;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
