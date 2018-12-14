package com.bank.kata.services;

import com.bank.kata.entities.Account;
import com.bank.kata.entities.Client;
import com.bank.kata.entities.Transaction;
import org.junit.*;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class TransactionServiceTest {

    public static Client client = null;
    public static Account account = null;
    public static Transaction transactionDeposit = null;
    public static Transaction transactionWithdrawal = null;
    public static TransactionService transactionService = new TransactionService();

    @Before
    public void initValues() {
        client = new Client("hamza", "abbes");
        account = new Account(new BigDecimal(0), new BigDecimal(0));
        transactionDeposit = new Transaction(new Date(), new BigDecimal(0), new BigDecimal(0), "DEPOSIT");
        transactionWithdrawal = new Transaction(new Date(), new BigDecimal(0), new BigDecimal(0), "WITHDRAWAL");
        account.setClient(client);
        account.initTransactions();
    }

    @After
    public void reIinitValues() {
        client = null;
        account = null;
        transactionDeposit = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmout() throws Exception {
        transactionDeposit.setAmount(new BigDecimal(-9));
        transactionService.deposit(account, transactionDeposit);
    }

    @Test
    public void testDepositPositiveAmout() throws Exception {
        transactionDeposit.setAmount(new BigDecimal(10));
        transactionService.deposit(account, transactionDeposit);
        assertEquals(new BigDecimal(10), account.getSolde());
        assertEquals(new BigDecimal(0), transactionDeposit.getBalanceBeforeTransaction());
    }

    @Test
    public void testDepositNullAmout() throws Exception {
        transactionDeposit.setAmount(new BigDecimal(0));
        transactionService.deposit(account, transactionDeposit);
        assertEquals(new BigDecimal(0), account.getSolde());
        assertEquals(new BigDecimal(0), transactionDeposit.getBalanceBeforeTransaction());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalNegativeAmout() throws Exception {
        transactionWithdrawal.setAmount(new BigDecimal(-9));
        transactionService.withdrawal(account, transactionWithdrawal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalAmoutGreaterThanSoldeAndOverdraft() throws Exception {
        account.setSolde(new BigDecimal(10));
        account.setOverDraftAmount(new BigDecimal(10));

        transactionWithdrawal.setAmount(new BigDecimal(30));
        transactionService.withdrawal(account, transactionWithdrawal);
    }

    @Test
    public void testWithdrawalAmoutLessThanSoldeAndOverdraft() throws Exception {
        account.setSolde(new BigDecimal(10));
        account.setOverDraftAmount(new BigDecimal(10));

        transactionWithdrawal.setAmount(new BigDecimal(5));
        transactionService.withdrawal(account, transactionWithdrawal);

        assertEquals(new BigDecimal(5), account.getSolde());
        assertEquals(new BigDecimal(0), transactionWithdrawal.getBalanceBeforeTransaction());

    }


}