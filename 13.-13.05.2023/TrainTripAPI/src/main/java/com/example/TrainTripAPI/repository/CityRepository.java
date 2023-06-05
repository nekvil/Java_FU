package com.example.TrainTripAPI.repository;

import com.example.TrainTripAPI.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing City entities in the TrainTripAPI.
 */
public interface CityRepository extends JpaRepository<City, Integer> {

    /**
     * Retrieves a list of cities by name.
     *
     * @param name The name of the cities to retrieve.
     * @return A list of cities with the specified name.
     */
    List<City> findByName(String name);
}
