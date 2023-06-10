package com.example.CoffeeAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name="table")
@Data
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number, consumer;

    @OneToMany(mappedBy = "tableId")
    @JsonIgnore
    private Set<Order> orderSet;

    public void updateTable(Table table){
        if(table.number != null){
            this.number = table.number;
        }
        if(table.consumer != null){
            this.consumer = table.consumer;
        }
    }
}
