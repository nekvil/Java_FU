package com.example.CoffeeAPI.controller;

import com.example.CoffeeAPI.model.Order;
import com.example.CoffeeAPI.model.Table;
import com.example.CoffeeAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Integer id){
        try{
            Order order = orderService.getOrderById(id);
            return new ResponseEntity<Order>(order, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/table_id/{tableId}")
    public List<Order> getByTableId(@PathVariable Table tableId){
        return orderService.getOrderByTableId(tableId);
    }

    @GetMapping("/total_value/{totalValue}")
    public List<Order> getByTotalValue(@PathVariable Double totalValue){
        return orderService.getOrderByTotalValue(totalValue);
    }

    @PostMapping("/")
    public void add(@RequestBody Order order){
        orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Integer id){
        try{
            Order baseOrder = orderService.getOrderById(id);
            baseOrder.updateOrder(order);
            orderService.saveOrder(baseOrder);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
