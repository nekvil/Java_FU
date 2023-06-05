package com.example.TrainTripAPI.repository;

import com.example.TrainTripAPI.model.TrainType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing TrainType entities in the TrainTripAPI.
 */
public interface TrainTypeRepository extends JpaRepository<TrainType, Integer> {

    /**
     * Retrieves a list of train types by name.
     *
     * @param name The name of the train types to retrieve.
     * @return A list of train types with the specified name.
     */
    List<TrainType> findByName(String name);
}
