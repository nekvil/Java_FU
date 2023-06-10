package com.example.CoffeeAPI.service;

import com.example.CoffeeAPI.model.Order;
import com.example.CoffeeAPI.model.Table;
import com.example.CoffeeAPI.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrderByTableId(Table tableId){
        return orderRepository.findByTableId(tableId);
    }

    public List<Order> getOrderByTotalValue(Double totalCost){
        return orderRepository.findByTotalValue(totalCost);
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }

    public Order getOrderById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }
}
