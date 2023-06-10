package com.example.HotelBookingAPI.repository;

import com.example.HotelBookingAPI.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
        List<Menu> findByName(String name);
        List<Menu> findByPricePerDay(Double pricePerDay);
}
