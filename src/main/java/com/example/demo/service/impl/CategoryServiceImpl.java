package com.example.demo.service.impl;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao dao;

    @Override
    public List<Category> findAll() {

        return dao.findAll();
    }

    @Override
    public Category create(Category obj) {
        int check = 0;
        while (check == 0) {
            Random rand = new Random();
            String number = String.valueOf(rand.nextInt(9000) + 1000);
            System.out.println("number: 0"+ number);
            Optional<Category> dto = dao.findById(number);
            if(dto.isEmpty()){
                check = 1;
                obj.setId(number);
            }else{
                check = 0;
            }
        }
        return dao.save(obj);
    }

    @Override
    public Category update(Category obj) {
        return dao.save(obj);
    }
}
