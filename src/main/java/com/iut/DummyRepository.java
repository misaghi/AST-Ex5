//package com.iut;
//
//import com.iut.account.model.Account;
//
//import java.util.ArrayList;
//import java.util.List;
//import com.iut.Repository;
//import com.iut.user.model.User;
//
//
//public class DummyRepository implements Repository<Account, String> {
//
//    private List<Account> accounts;
//
//    public DummyRepository() {
//        accounts = new ArrayList<>();
//    }
//
//    @Override
//    public boolean save(Account input) {
//        if (input.getUserId()) {
//            return false;
//        }
//        return true;User
//    }
//
//    @Override
//    public boolean update(Account input) {
//    return true;
//    }
//
//    @Override
//    public boolean delete(String id) {
//    return true;
//    }
//    @Override
//    public boolean existsById(String id) {
//        return true;
//    }
//
//    @Override
//    public Account findById(String id) {
//    }
//
//    @Override
//    public List<Account> findAll() {
//    }
//}
