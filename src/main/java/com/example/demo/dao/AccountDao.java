package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDao extends JpaRepository<Account, String> {
    Account findAccountsByUsername(String username);

    Account findByUsername(String username);
}
