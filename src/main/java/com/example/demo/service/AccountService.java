package com.example.demo.service;

import com.example.demo.entity.Account;

import java.util.List;

public interface AccountService {
    Account findById(String username);

    List<Account> getAdministrators();

    List<Account> findAll();

    List<Account> findAuthoriesOfAdministrator();
}
