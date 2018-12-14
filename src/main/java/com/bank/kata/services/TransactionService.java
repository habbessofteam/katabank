package com.bank.kata.services;

import com.bank.kata.entities.Account;
import com.bank.kata.entities.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TransactionService {

    public Account deposit(Account account, Transaction transaction) throws Exception{

        if(transaction.getAmount().compareTo (new BigDecimal(0)) == -1){
            throw new IllegalArgumentException();
        }
        transaction.setBalanceBeforeTransaction(account.getSolde());
        account.setSolde(account.getSolde().add(transaction.getAmount()));
        account.addTransaction(transaction);

        return account;
    }

    public Account withdrawal(Account account, Transaction transaction) throws Exception{

        if((transaction.getAmount().compareTo (new BigDecimal(0)) == -1) || (account.getSolde().add(account.getOverDraftAmount()).compareTo(transaction.getAmount()) == -1)){
            throw new IllegalArgumentException();
        }
        account.setSolde(account.getSolde().subtract(transaction.getAmount()));

        account.addTransaction(transaction);

        return account;
    }

    public ArrayList<Transaction> getHistory(Account account){
        return account.getTransactions();
    }
}

