package com.example.demo.dao;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProductDao extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    List<Product> findProductByCategoryId(@Param("category") String cid);
}
