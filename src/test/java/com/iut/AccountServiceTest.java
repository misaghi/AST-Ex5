package com.iut;

import org.junit.jupiter.api.*;

import com.iut.account.model.Account;
import com.iut.account.service.AccountService;

public class AccountServiceTest {

    private DummyRepository repository;
    private AccountService accountService;

    private final String accountId = "0";
    private final String userId = "1234";
    private final int balance = 2000;

    @BeforeEach
    void setup() {
        repository = new DummyRepository();
        accountService = new AccountService(repository);
    }

    @AfterEach
    void teardown() {
        repository = null;
        accountService = null;
    }

    @Test
    void createAccountTest() {
        Assertions.assertTrue(accountService.createAccount(accountId, balance, userId));
        Assertions.assertEquals(1, accountService.getAllAccounts(userId).size());
    }

    @Test
    void depositTest() {
        accountService.createAccount(accountId, balance, userId);
        Assertions.assertTrue(accountService.deposit(accountId, 1000));
        Assertions.assertFalse(accountService.deposit("3434", 1000));
        Assertions.assertEquals(3000, accountService.getBalance(accountId));
    }

    @Test
    void withdrawTest() {
        accountService.createAccount(accountId, balance, userId);
        Assertions.assertTrue(accountService.withdraw(accountId, 2000));
        Assertions.assertFalse(accountService.withdraw("3454", 2000));
        Assertions.assertEquals(balance - 2000, accountService.getBalance(accountId));
    }

    @Test
    void transferTest() {
        accountService.createAccount(accountId, balance, userId);
        accountService.createAccount("10", 5000, "4321");
        Assertions.assertFalse(accountService.transfer("11", accountId, 1000));
        Assertions.assertFalse(accountService.transfer(accountId, "11", 1000));
        Assertions.assertFalse(accountService.transfer("12", "11", 1000));
        Assertions.assertTrue(accountService.transfer("10", accountId, 2500));
        Assertions.assertEquals(2500, accountService.getBalance("10"));
        Assertions.assertEquals(4500, accountService.getBalance(accountId));
    }

    @Test
    void getBalanceTest() {
        accountService.createAccount(accountId, balance, userId);
        Assertions.assertEquals(balance, accountService.getBalance(accountId));
        Assertions.assertThrows(IllegalArgumentException.class, () -> accountService.getBalance("1234333"));
    }

    @Test
    void existsAndGetAccountTest() {
        accountService.createAccount(accountId, balance, userId);
        Assertions.assertEquals(accountId, accountService.getAccount(accountId).getId());
        Assertions.assertNull(accountService.getAccount("333"));
    }

    @Test
    void getAllAccountsTest() {
        accountService.createAccount(accountId, balance, userId);
        accountService.createAccount("12334444", balance, userId);
        accountService.createAccount("10", 5000, "4321");
        Assertions.assertEquals(2, accountService.getAllAccounts(userId).size());
        Assertions.assertEquals(0, accountService.getAllAccounts("234234").size());
    }

}
