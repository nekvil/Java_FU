package com.example.TrainTripAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * Represents a train type in the TrainTripAPI.
 */
@Entity(name="train_type")
@Data
public class TrainType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "trainTypeId")
    @JsonIgnore
    private Set<Train> trainSet;

    /**
     * Updates the train type with the properties of the given train type object.
     *
     * @param trainType The train type object containing updated properties.
     */
    public void updateType(TrainType trainType){
        if(trainType.name != null){
            this.name = trainType.name;
        }
    }
}
