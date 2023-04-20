package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao dao;

    @Override
    public List<Product> findAll() {
        return dao.findAll();

    }

    @Override
    public Product findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(String cid) {
        return dao.findProductByCategoryId(cid);
    }

    @Override
    public Product create(Product obj) {
        return dao.save(obj);
    }

    @Override
    public Product update(Product obj) {
        return dao.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
         dao.deleteById(id);
    }


}
