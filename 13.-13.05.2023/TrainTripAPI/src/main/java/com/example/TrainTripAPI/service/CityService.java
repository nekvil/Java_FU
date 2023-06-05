package com.example.TrainTripAPI.service;

import com.example.TrainTripAPI.model.City;
import com.example.TrainTripAPI.repository.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing City entities in the TrainTripAPI.
 */
@Service
@Transactional
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    /**
     * Retrieves all cities.
     *
     * @return A list of all cities.
     */
    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    /**
     * Retrieves cities by name.
     *
     * @param name The name of the city.
     * @return A list of cities with the specified name.
     */
    public List<City> getCityByName(String name){
        return cityRepository.findByName(name);
    }

    /**
     * Saves a city.
     *
     * @param city The city to be saved.
     */
    public void saveCity(City city){
        cityRepository.save(city);
    }

    /**
     * Deletes a city by ID.
     *
     * @param id The ID of the city to be deleted.
     */
    public void deleteCity(Integer id){
        cityRepository.deleteById(id);
    }

    /**
     * Retrieves a city by ID.
     *
     * @param id The ID of the city.
     * @return The city with the specified ID, or null if not found.
     */
    public City getCityById(Integer id){
        return cityRepository.findById(id).orElse(null);
    }
}
