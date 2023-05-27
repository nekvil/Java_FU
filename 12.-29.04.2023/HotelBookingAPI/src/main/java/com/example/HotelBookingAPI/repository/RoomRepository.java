package com.example.HotelBookingAPI.repository;

import com.example.HotelBookingAPI.model.Room;
import com.example.HotelBookingAPI.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByRoomNumber(String roomNumber);
    List<Room> findByFloorNumber(Integer floorNumber);
    List<Room> findByPricePerNight(Double pricePerNight);
    List<Room> findByRoomTypeId(RoomType roomTypeId);
}
