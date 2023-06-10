package com.example.HotelBookingAPI.repository;

import com.example.HotelBookingAPI.model.Order;
import com.example.HotelBookingAPI.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByRoomId(Room roomId);
    List<Order> findByClientId(Table tableId);
    List<Order> findByCheckInDate(LocalDateTime checkInDate);
    List<Order> findByCheckOutDate(LocalDateTime checkOutDate);
    List<Order> findByTotalCost(Double totalCost);
}
