package com.example.TrainTripAPI.controller;

import com.example.TrainTripAPI.model.City;
import com.example.TrainTripAPI.model.Train;
import com.example.TrainTripAPI.model.Trip;
import com.example.TrainTripAPI.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    /**
     * Retrieves all trips.
     *
     * @return the list of all trips
     */
    @GetMapping("")
    public List<Trip> getAllTrips(){
        return tripService.getAllTrips();
    }

    /**
     * Retrieves a trip by its ID.
     *
     * @param id the ID of the trip
     * @return the ResponseEntity with the retrieved trip if found, or NOT_FOUND if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Trip> get(@PathVariable Integer id){
        try{
            Trip trip = tripService.getTripById(id);
            return new ResponseEntity<Trip>(trip, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Trip>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves trips by train ID.
     *
     * @param trainId the train ID
     * @return the list of trips with the specified train ID
     */
    @GetMapping("/train_id/{trainId}")
    public List<Trip> getByTrainId(@PathVariable Train trainId){
        return tripService.getTripByTrainId(trainId);
    }

    /**
     * Retrieves trips by departure city ID.
     *
     * @param departureCityId the departure city ID
     * @return the list of trips with the specified departure city ID
     */
    @GetMapping("/departure_city/{departureCityId}")
    public List<Trip> getByDepartureCity(@PathVariable City departureCityId){
        return tripService.getTripByDepartureCityId(departureCityId);
    }

    /**
     * Retrieves trips by arrival city ID.
     *
     * @param arrivalCityId the arrival city ID
     * @return the list of trips with the specified arrival city ID
     */
    @GetMapping("/arrival_city/{arrivalCityId}")
    public List<Trip> getByArrivalCity(@PathVariable City arrivalCityId){
        return tripService.getTripByArrivalCityId(arrivalCityId);
    }

    /**
     * Retrieves trips by departure date.
     *
     * @param departureDate the departure date in the format "yyyy-MM-dd"
     * @return the list of trips with the specified departure date
     */
    @GetMapping("/departure_date/{departureDate}")
    public List<Trip> getByDepartureDate(@PathVariable String departureDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate _departureDate = LocalDate.parse(departureDate, formatter);
        return tripService.getTripByDepartureDate(_departureDate);
    }

    /**
     * Retrieves trips by arrival date.
     *
     * @param arrivalDate the arrival date in the format "yyyy-MM-dd"
     * @return the list of trips with the specified arrival date
     */
    @GetMapping("/arrival_date/{arrivalDate}")
    public List<Trip> getByArrivalDate(@PathVariable String arrivalDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate _arrivalDate = LocalDate.parse(arrivalDate, formatter);
        return tripService.getTripByArrivalDate(_arrivalDate);
    }

    /**
     * Retrieves trips by departure time.
     *
     * @param departureTime the departure time in the format "HH:mm"
     * @return the list of trips with the specified departure time
     */
    @GetMapping("/departure_time/{departureTime}")
    public List<Trip> getByDepartureTime(@PathVariable String departureTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime _departureTime = LocalTime.parse(departureTime, formatter);
        return tripService.getTripByDepartureTime(_departureTime);
    }

    /**
     * Retrieves trips by arrival time.
     *
     * @param arrivalTime the arrival time in the format "HH:mm"
     * @return the list of trips with the specified arrival time
     */
    @GetMapping("/arrival_time/{arrivalTime}")
    public List<Trip> getByArrivalTime(@PathVariable String arrivalTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime _arrivalTime = LocalTime.parse(arrivalTime, formatter);
        return tripService.getTripByArrivalTime(_arrivalTime);
    }

    /**
     * Retrieves trips by available seats.
     *
     * @param availableSeats the number of available seats
     * @return the list of trips with the specified number of available seats
     */
    @GetMapping("/available_seats/{availableSeats}")
    public List<Trip> getByAvailableSeats(@PathVariable Integer availableSeats){
        return tripService.getTripByAvailableSeats(availableSeats);
    }

    /**
     * Retrieves trips by total seats.
     *
     * @param totalSeats the total number of seats
     * @return the list of trips with the specified total number of seats
     */
    @GetMapping("/total_seats/{totalSeats}")
    public List<Trip> getByTotalSeats(@PathVariable Integer totalSeats){
        return tripService.getTripByTotalSeats(totalSeats);
    }

    /**
     * Retrieves trips by base price.
     *
     * @param basePrice the base price
     * @return the list of trips with the specified base price
     */
    @GetMapping("/base_price/{basePrice}")
    public List<Trip> getByTotalSeats(@PathVariable Double basePrice){
        return tripService.getTripByBasePrice(basePrice);
    }

    /**
     * Adds a new trip.
     *
     * @param trip the trip to be added
     */
    @PostMapping("/")
    public void add(@RequestBody Trip trip){
        tripService.saveTrip(trip);
    }

    /**
     * Deletes a trip by its ID.
     *
     * @param id the ID of the trip to be deleted
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        tripService.deleteTrip(id);
    }

    /**
     * Updates a trip by its ID.
     *
     * @param trip the updated trip object
     * @param id the ID of the trip to be updated
     * @return the ResponseEntity with HTTP status OK if the trip is updated successfully, or NOT_FOUND if the trip is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Trip trip, @PathVariable Integer id){
        try{
            Trip baseTrip = tripService.getTripById(id);
            baseTrip.updateTrip(trip);
            tripService.saveTrip(baseTrip);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
