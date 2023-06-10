package com.example.HotelBookingAPI.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="menu")
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer price;

    @ManyToMany(mappedBy = "additionalServiceSet")
    private Set<Order> orderSet;

    public void updateAdditionalService(Menu menu){
        if(menu.name != null){
            this.name = menu.name;
        }
    }

}
