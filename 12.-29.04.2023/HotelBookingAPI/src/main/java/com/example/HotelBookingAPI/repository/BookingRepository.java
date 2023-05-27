package com.example.HotelBookingAPI.repository;

import com.example.HotelBookingAPI.model.Booking;
import com.example.HotelBookingAPI.model.Client;
import com.example.HotelBookingAPI.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByRoomId(Room roomId);
    List<Booking> findByClientId(Client clientId);
    List<Booking> findByCheckInDate(LocalDateTime checkInDate);
    List<Booking> findByCheckOutDate(LocalDateTime checkOutDate);
    List<Booking> findByTotalCost(Double totalCost);
}
