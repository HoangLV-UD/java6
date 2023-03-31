package com.example.demo.dao;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ProductDao extends JpaRepository<Product, Integer> {
//    @Query(value = " SELECT p.id, p.name, pp.price, i.link_image FROM product p " +
//            " LEFT JOIN rom r ON p.id = r.product_id" +
//            " LEFT JOIN property_product pp ON r.rom_id = r.id" +
//            " LEFT JOIN image i ON p.id = i.product_id")
    List<Product> findAll();
}
