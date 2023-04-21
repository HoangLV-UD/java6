package com.example.demo.service.impl;

import com.example.demo.dao.AccountDao;
import com.example.demo.dao.AuthorityDao;
import com.example.demo.entity.Account;
import com.example.demo.entity.Authority;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    AuthorityDao authorityDao;
    @Override
    public List<Authority> findAuthoriesOfAdministrator() {
        List<Account> list = accountDao.getAdministrators();
        return authorityDao.authoritiesOf(list);
    }

    @Override
    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    @Override
    public Authority save(Authority obj) {
        return authorityDao.save(obj);
    }

    @Override
    public void delete(Integer id) {
        try {
            authorityDao.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
