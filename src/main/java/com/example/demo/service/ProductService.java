package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategoryId(String cid);
}
