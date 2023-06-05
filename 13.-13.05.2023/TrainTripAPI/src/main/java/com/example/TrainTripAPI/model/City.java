package com.example.TrainTripAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * Represents a city in the TrainTripAPI.
 */
@Entity(name="city")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "departureCity")
    @JsonIgnore
    private Set<Trip> tripSetDepartureCity;

    @OneToMany(mappedBy = "arrivalCity")
    @JsonIgnore
    private Set<Trip> tripSetArrivalCity;

    /**
     * Updates the city with the properties of the given city object.
     *
     * @param city The city object containing updated properties.
     */
    public void updateCity(City city){
        if(city.name != null){
            this.name = city.name;
        }
    }
}
