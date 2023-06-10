package com.example.HotelBookingAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity(name="table")
@Data
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName, firstName, middleName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "clientId")
    @JsonIgnore
    private Set<Order> orderSetClient;

    public void updateClient(Table table){
        if(table.lastName != null){
            this.lastName = table.lastName;
        }
        if(table.firstName != null){
            this.firstName = table.firstName;
        }
        if(table.middleName != null){
            this.middleName = table.middleName;
        }
        if(table.dateOfBirth != null){
            this.dateOfBirth = table.dateOfBirth;
        }
    }
}
