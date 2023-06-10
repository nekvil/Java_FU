package com.example.HotelBookingAPI.controller;

import com.example.HotelBookingAPI.model.Order;
import com.example.HotelBookingAPI.model.Table;
import com.example.HotelBookingAPI.service.MenuService;
import com.example.HotelBookingAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("")
    public List<Order> getAllBookings(){
        return menuService.getAllAdditionalServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Integer id){
        try{
            Order order = orderService.getBookingById(id);
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/room-id/{roomId}")
    public List<Order> getByRoomId(@PathVariable Room roomId){
        return orderService.getBookingByRoomId(roomId);
    }

    @GetMapping("/client-id/{clientId}")
    public List<Order> getByClientId(@PathVariable Table tableId){
        return orderService.getBookingByClientId(tableId);
    }

    @GetMapping("/check-in-date/{checkInDate}")
    public List<Order> getByCheckInDate(@PathVariable String checkInDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime _checkInDate = LocalDateTime.parse(checkInDate, formatter);
        return orderService.getBookingByCheckInDate(_checkInDate);
    }

    @GetMapping("/check-out-date/{checkOutDate}")
    public List<Order> getByCheckOutDate(@PathVariable String checkOutDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime _checkOutDate = LocalDateTime.parse(checkOutDate, formatter);
        return orderService.getBookingByCheckOutDate(_checkOutDate);
    }

    @GetMapping("/total-cost/{totalCost}")
    public List<Order> getByPricePerNight(@PathVariable Double totalCost){
        return orderService.getBookingByTotalCost(totalCost);
    }

    @PostMapping("/")
    public void add(@RequestBody Order order){
        orderService.saveBooking(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        orderService.deleteBooking(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Integer id){
        try{
            Order baseOrder = orderService.getBookingById(id);
            baseOrder.updateBooking(order);
            orderService.saveBooking(baseOrder);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
