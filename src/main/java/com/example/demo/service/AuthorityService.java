package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Authority;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorityService {
    List<Authority> findAuthoriesOfAdministrator();

    List<Authority> findAll();

    Authority save(Authority obj);

    void delete(Integer id);
}
