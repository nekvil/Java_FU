package com.example.HotelBookingAPI.repository;

import com.example.HotelBookingAPI.model.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Integer> {
        List<AdditionalService> findByName(String name);
        List<AdditionalService> findByPricePerDay(Double pricePerDay);
}
