package com.example.CoffeeAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="menu")
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Double price;

    @ManyToMany(mappedBy = "menuSet")
    private Set<Order> orderSet;

    public void updateMenu(Menu menu){
        if(menu.name != null){
            this.name = menu.name;
        }
        if(menu.price != null){
            this.price = menu.price;
        }
    }

}
