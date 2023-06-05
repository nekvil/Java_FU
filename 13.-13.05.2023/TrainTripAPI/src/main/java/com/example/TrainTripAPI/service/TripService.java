package com.example.TrainTripAPI.service;

import com.example.TrainTripAPI.model.City;
import com.example.TrainTripAPI.model.Train;
import com.example.TrainTripAPI.model.Trip;
import com.example.TrainTripAPI.repository.TripRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Service class for managing Trip entities in the TrainTripAPI.
 */
@Service
@Transactional
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    /**
     * Retrieves all trips.
     *
     * @return A list of all trips.
     */
    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    /**
     * Retrieves trips by train ID.
     *
     * @param trainId The ID of the train.
     * @return A list of trips with the specified train ID.
     */
    public List<Trip> getTripByTrainId(Train trainId){
        return tripRepository.findByTrainId(trainId);
    }

    /**
     * Retrieves trips by departure city.
     *
     * @param departureCity The departure city.
     * @return A list of trips with the specified departure city.
     */
    public List<Trip> getTripByDepartureCityId(City departureCity){
        return tripRepository.findByDepartureCity(departureCity);
    }

    /**
     * Retrieves trips by arrival city.
     *
     * @param arrivalCity The arrival city.
     * @return A list of trips with the specified arrival city.
     */
    public List<Trip> getTripByArrivalCityId(City arrivalCity){
        return tripRepository.findByArrivalCity(arrivalCity);
    }

    /**
     * Retrieves trips by departure date.
     *
     * @param departureDate The departure date.
     * @return A list of trips with the specified departure date.
     */
    public List<Trip> getTripByDepartureDate(LocalDate departureDate){
        return tripRepository.findByDepartureDate(departureDate);
    }

    /**
     * Retrieves trips by arrival date.
     *
     * @param arrivalDate The arrival date.
     * @return A list of trips with the specified arrival date.
     */
    public List<Trip> getTripByArrivalDate(LocalDate arrivalDate){
        return tripRepository.findByArrivalDate(arrivalDate);
    }

    /**
     * Retrieves trips by departure time.
     *
     * @param departureTime The departure time.
     * @return A list of trips with the specified departure time.
     */
    public List<Trip> getTripByDepartureTime(LocalTime departureTime){
        return tripRepository.findByDepartureTime(departureTime);
    }

    /**
     * Retrieves trips by arrival time.
     *
     * @param arrivalTime The arrival time.
     * @return A list of trips with the specified arrival time.
     */
    public List<Trip> getTripByArrivalTime(LocalTime arrivalTime){
        return tripRepository.findByArrivalTime(arrivalTime);
    }

    /**
     * Retrieves trips by available seats.
     *
     * @param availableSeats The number of available seats.
     * @return A list of trips with the specified number of available seats.
     */
    public List<Trip> getTripByAvailableSeats(Integer availableSeats){
        return tripRepository.findByAvailableSeats(availableSeats);
    }

    /**
     * Retrieves trips by total seats.
     *
     * @param totalSeats The total number of seats.
     * @return A list of trips with the specified total number of seats.
     */
    public List<Trip> getTripByTotalSeats(Integer totalSeats){
        return tripRepository.findByTotalSeats(totalSeats);
    }

    /**
     * Retrieves trips by base price.
     *
     * @param basePrice The base price.
     * @return A list of trips with the specified base price.
     */
    public List<Trip> getTripByBasePrice(Double basePrice){
        return tripRepository.findByBasePrice(basePrice);
    }

    /**
     * Saves a trip.
     *
     * @param trip The trip to be saved.
     */
    public void saveTrip(Trip trip){
        tripRepository.save(trip);
    }

    /**
     * Deletes a trip by ID.
     *
     * @param id The ID of the trip to be deleted.
     */
    public void deleteTrip(Integer id){
        tripRepository.deleteById(id);
    }

    /**
     * Retrieves a trip by ID.
     *
     * @param id The ID of the trip.
     * @return The trip with the specified ID, or null if not found.
     */
    public Trip getTripById(Integer id){
        return tripRepository.findById(id).orElse(null);
    }
}
