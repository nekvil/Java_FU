package com.example.CoffeeAPI.repository;

import com.example.CoffeeAPI.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<Table, Integer> {
    List<Table> findByNumber(String number);
    List<Table> findByConsumer(String consumer);
}
