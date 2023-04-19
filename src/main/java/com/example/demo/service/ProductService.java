package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService  {
    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategoryId(String cid);
}
