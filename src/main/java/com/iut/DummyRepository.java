package com.iut;

import com.iut.account.model.Account;

import java.util.ArrayList;
import java.util.List;


public class DummyRepository implements Repository<Account, String> {

    private List<Account> accounts;

    public DummyRepository() {
        accounts = new ArrayList<>();
    }

    @Override
    public boolean save(Account input) {
        try {
            accounts.add(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Account input) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(input.getId())) {
                accounts.remove(i);
                accounts.add(input);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean existsById(String accountId) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(accountId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Account findById(String accountId) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(accountId)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public List<Account> findAllById(String userId) {
        List<Account> result = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserId().equals(userId)) {
                result.add(accounts.get(i));
            }
        }
        return result;
    }
}
