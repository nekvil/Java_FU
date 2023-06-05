package com.example.TrainTripAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * Represents a train in the TrainTripAPI.
 */
@Entity(name="train")
@Data
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name, number;
    private Integer carCount, seatsPerCar;

    @ManyToOne
    @JoinColumn(name="trainTypeId", nullable = false)
    private TrainType trainTypeId;

    @OneToMany(mappedBy = "trainId")
    @JsonIgnore
    private Set<Trip> tripSet;

    /**
     * Updates the train with the properties of the given train object.
     *
     * @param train The train object containing updated properties.
     */
    public void updateTrain(Train train){
        if(train.name != null){
            this.name = train.name;
        }
        if(train.trainTypeId != null){
            this.trainTypeId = train.trainTypeId;
        }
        if(train.number != null){
            this.number = train.number;
        }
        if(train.carCount != null){
            this.carCount = train.carCount;
        }
        if(train.seatsPerCar != null){
            this.seatsPerCar = train.seatsPerCar;
        }
    }
}