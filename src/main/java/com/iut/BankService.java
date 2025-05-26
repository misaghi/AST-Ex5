package com.iut;

import com.iut.account.model.Account;
import com.iut.account.service.AccountService;
import com.iut.user.model.User;
import com.iut.user.service.UserService;

import java.util.List;

public class BankService {
    private final UserService userService;
    private final AccountService accountService;

    public BankService(final UserService userService, final AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    public boolean registerNewUser(User user) {
        return this.userService.createUser(user) && this.accountService.createAccount("0", 0, user.getId());
    }

    public List<Account> getUserAccounts(String userId) {
        return accountService.getAllAccounts(userId);
    }

    public User getUser(String userId) {
        return userService.getUser(userId);
    }

    public boolean addAccountToUser(String userId, Account account) {
        return accountService.createAccount(account.getId(), account.getBalance(), userId);
    }

    public Account getAccount(String accountId) {
        return accountService.getAccount((accountId));
    }

    public boolean deleteAccount(String accountId) {
        return accountService.deleteAccount(accountId);
    }

}
