package com.example.demo.dao;

import com.example.demo.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order,Long> {


    @Query("SELECT o FROM Order o WHERE o.account.username=?1")
    List<Order> findByUsername(String username);
}
