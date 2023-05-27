package com.example.HotelBookingAPI.service;

import com.example.HotelBookingAPI.model.Room;
import com.example.HotelBookingAPI.model.RoomType;
import com.example.HotelBookingAPI.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public List<Room> getRoomByRoomNumber(String roomNumber){
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public List<Room> getRoomByFloorNumber(Integer floorNumber){
        return roomRepository.findByFloorNumber(floorNumber);
    }

    public List<Room> getRoomByPricePerNight(Double pricePerNight){
        return roomRepository.findByPricePerNight(pricePerNight);
    }

    public List<Room> getRoomByRoomTypeId(RoomType roomTypeId){
        return roomRepository.findByRoomTypeId(roomTypeId);
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }

    public void deleteRoom(Integer id){
        roomRepository.deleteById(id);
    }

    public Room getRoomById(Integer id){
        return roomRepository.findById(id).orElse(null);
    }
}
