package com.example.TrainTripAPI.repository;

import com.example.TrainTripAPI.model.City;
import com.example.TrainTripAPI.model.Train;
import com.example.TrainTripAPI.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Repository interface for managing Trip entities in the TrainTripAPI.
 */
public interface TripRepository extends JpaRepository<Trip, Integer> {

    /**
     * Retrieves a list of trips by train ID.
     *
     * @param trainId The ID of the train.
     * @return A list of trips associated with the specified train.
     */
    List<Trip> findByTrainId(Train trainId);

    /**
     * Retrieves a list of trips by departure city.
     *
     * @param departureCityId The departure city.
     * @return A list of trips with the specified departure city.
     */
    List<Trip> findByDepartureCity(City departureCityId);

    /**
     * Retrieves a list of trips by arrival city.
     *
     * @param arrivalCityId The arrival city.
     * @return A list of trips with the specified arrival city.
     */
    List<Trip> findByArrivalCity(City arrivalCityId);

    /**
     * Retrieves a list of trips by departure date.
     *
     * @param departureDate The departure date.
     * @return A list of trips with the specified departure date.
     */
    List<Trip> findByDepartureDate(LocalDate departureDate);

    /**
     * Retrieves a list of trips by arrival date.
     *
     * @param arrivalDate The arrival date.
     * @return A list of trips with the specified arrival date.
     */
    List<Trip> findByArrivalDate(LocalDate arrivalDate);

    /**
     * Retrieves a list of trips by departure time.
     *
     * @param departureTime The departure time.
     * @return A list of trips with the specified departure time.
     */
    List<Trip> findByDepartureTime(LocalTime departureTime);

    /**
     * Retrieves a list of trips by arrival time.
     *
     * @param arrivalTime The arrival time.
     * @return A list of trips with the specified arrival time.
     */
    List<Trip> findByArrivalTime(LocalTime arrivalTime);

    /**
     * Retrieves a list of trips by available seats.
     *
     * @param availableSeats The number of available seats.
     * @return A list of trips with the specified number of available seats.
     */
    List<Trip> findByAvailableSeats(Integer availableSeats);

    /**
     * Retrieves a list of trips by total seats.
     *
     * @param totalSeats The total number of seats.
     * @return A list of trips with the specified total number of seats.
     */
    List<Trip> findByTotalSeats(Integer totalSeats);

    /**
     * Retrieves a list of trips by base price.
     *
     * @param basePrice The base price.
     * @return A list of trips with the specified base price.
     */
    List<Trip> findByBasePrice(Double basePrice);
}
