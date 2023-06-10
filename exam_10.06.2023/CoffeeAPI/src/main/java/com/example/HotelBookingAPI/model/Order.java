package com.example.HotelBookingAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name="order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="clientId", nullable = false)
    private Table tableId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime checkInDate, checkOutDate;

    private Double totalCost;

    @ManyToMany
    @JoinTable(name = "bookingAdditionalService",
            joinColumns = {
                    @JoinColumn(name = "bookingId", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "additionalServiceId", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Menu> menuSet;

    public void updateBooking(Order order){
        if(order.tableId != null){
            this.tableId = order.tableId;
        }
        if(order.checkInDate != null){
            this.checkInDate = order.checkInDate;
        }
        if(order.checkOutDate != null){
            this.checkOutDate = order.checkOutDate;
        }
        if(order.totalCost != null){
            this.totalCost = order.totalCost;
        }
    }

}
