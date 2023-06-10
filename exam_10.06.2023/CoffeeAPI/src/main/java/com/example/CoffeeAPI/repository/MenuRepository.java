package com.example.CoffeeAPI.repository;

import com.example.CoffeeAPI.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
        List<Menu> findByName(String name);
        List<Menu> findByPrice(Double price);
}
