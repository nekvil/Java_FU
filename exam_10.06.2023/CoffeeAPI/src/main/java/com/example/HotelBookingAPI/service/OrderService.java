package com.example.HotelBookingAPI.service;

import com.example.HotelBookingAPI.model.Order;
import com.example.HotelBookingAPI.model.Table;
import com.example.HotelBookingAPI.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getBookingByCheckInDate(LocalDateTime checkInDate){
        return orderRepository.findByCheckInDate(checkInDate);
    }

    public List<Order> getBookingByCheckOutDate(LocalDateTime checkOutDate){
        return orderRepository.findByCheckOutDate(checkOutDate);
    }

    public List<Order> getBookingByTotalCost(Double totalCost){
        return orderRepository.findByTotalCost(totalCost);
    }

    public void saveBooking(Order order){
        orderRepository.save(order);
    }

    public void deleteBooking(Integer id){
        orderRepository.deleteById(id);
    }

    public Order getBookingById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }
}
