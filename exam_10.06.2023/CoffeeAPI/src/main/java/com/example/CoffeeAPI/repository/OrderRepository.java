package com.example.CoffeeAPI.repository;

import com.example.CoffeeAPI.model.Order;
import com.example.CoffeeAPI.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByTableId(Table tableId);
    List<Order> findByTotalValue(Double totalValue);
}
