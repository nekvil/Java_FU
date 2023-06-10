package com.example.CoffeeAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="tableId", nullable = false)
    private Table tableId;

    private Double totalValue;

    @ManyToMany
    @JoinTable(name = "orderMenu",
            joinColumns = {
                    @JoinColumn(name = "orderId", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "menuId", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Menu> menuSet;

    public void updateOrder(Order order){
        if(order.tableId != null){
            this.tableId = order.tableId;
        }
        if(order.totalValue != null){
            this.totalValue = order.totalValue;
        }
    }

}
