package com.example.TrainTripAPI.controller;

import com.example.TrainTripAPI.model.City;
import com.example.TrainTripAPI.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * Retrieves all cities.
     *
     * @return the list of all cities
     */
    @GetMapping("")
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    /**
     * Retrieves a city by its ID.
     *
     * @param id the ID of the city
     * @return the ResponseEntity with the retrieved city if found, or NOT_FOUND if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<City> get(@PathVariable Integer id){
        try{
            City city = cityService.getCityById(id);
            return new ResponseEntity<City>(city, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves cities by name.
     *
     * @param name the name of the cities
     * @return the list of cities with the specified name
     */
    @GetMapping("/name/{name}")
    public List<City> getByName(@PathVariable String name){
        return cityService.getCityByName(name);
    }

    /**
     * Adds a new city.
     *
     * @param city the city to be added
     */
    @PostMapping("/")
    public void add(@RequestBody City city){
        cityService.saveCity(city);
    }

    /**
     * Deletes a city by its ID.
     *
     * @param id the ID of the city to be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        cityService.deleteCity(id);
    }

    /**
     * Updates a city by its ID.
     *
     * @param city the updated city object
     * @param id the ID of the city to be updated
     * @return the ResponseEntity with HTTP status OK if the city is updated successfully, or NOT_FOUND if the city is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody City city, @PathVariable Integer id){
        try{
            City baseCity = cityService.getCityById(id);
            baseCity.updateCity(city);
            cityService.saveCity(baseCity);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
