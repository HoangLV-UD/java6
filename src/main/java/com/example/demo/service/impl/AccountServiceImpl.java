package com.example.demo.service.impl;

import com.example.demo.dao.AccountDao;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;


    @Override
    public Account findById(String username) {
        return dao.findById(username).get();
    }

    @Override
    public List<Account> getAdministrators() {
        return dao.getAdministrators();
    }

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Account> findAuthoriesOfAdministrator() {

        return null;
    }
}
