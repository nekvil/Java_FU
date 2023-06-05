package com.example.traintripfx.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The Trip class represents a trip in the train trip application.
 */
public class Trip {

    private Integer id; // The ID of the trip
    private Integer availableSeats; // The number of available seats
    private Integer totalSeats; // The total number of seats
    private Double basePrice; // The base price of the trip
    private LocalDate departureDate; // The departure date of the trip
    private LocalDate arrivalDate; // The arrival date of the trip
    private LocalTime departureTime; // The departure time of the trip
    private LocalTime arrivalTime; // The arrival time of the trip
    private Train trainId; // The train for the trip
    private City departureCity; // The departure city of the trip
    private City arrivalCity; // The arrival city of the trip

    /**
     * Constructs an empty Trip object.
     */
    public Trip() {
    }

    /**
     * Constructs a Trip object with the specified details.
     *
     * @param trainId         The train for the trip.
     * @param departureCity   The departure city of the trip.
     * @param arrivalCity     The arrival city of the trip.
     * @param departureDate   The departure date of the trip.
     * @param departureTime   The departure time of the trip.
     * @param arrivalDate     The arrival date of the trip.
     * @param arrivalTime     The arrival time of the trip.
     * @param availableSeats  The number of available seats.
     * @param totalSeats      The total number of seats.
     * @param basePrice       The base price of the trip.
     */
    public Trip(Train trainId,
                City departureCity,
                City arrivalCity,
                LocalDate departureDate,
                LocalTime departureTime,
                LocalDate arrivalDate,
                LocalTime arrivalTime,
                Integer availableSeats,
                Integer totalSeats,
                Double basePrice) {
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.basePrice = basePrice;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.trainId = trainId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    /**
     * Returns the ID of the trip.
     *
     * @return The ID of the trip.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the trip.
     *
     * @param id The ID of the trip.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the number of available seats.
     *
     * @return The number of available seats.
     */
    public Integer getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Sets the number of available seats.
     *
     * @param availableSeats The number of available seats.
     */
    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * Returns the total number of seats.
     *
     * @return The total number of seats.
     */
    public Integer getTotalSeats() {
        return totalSeats;
    }

    /**
     * Sets the total number of seats.
     *
     * @param totalSeats The total number of seats.
     */
    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    /**
     * Returns the base price of the trip.
     *
     * @return The base price of the trip.
     */
    public Double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price of the trip.
     *
     * @param basePrice The base price of the trip.
     */
    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Returns the departure date of the trip.
     *
     * @return The departure date of the trip.
     */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the departure date of the trip.
     *
     * @param departureDate The departure date of the trip.
     */
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Returns the arrival date of the trip.
     *
     * @return The arrival date of the trip.
     */
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the arrival date of the trip.
     *
     * @param arrivalDate The arrival date of the trip.
     */
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * Returns the departure time of the trip.
     *
     * @return The departure time of the trip.
     */
    public LocalTime getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the departure time of the trip.
     *
     * @param departureTime The departure time of the trip.
     */
    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Returns the arrival time of the trip.
     *
     * @return The arrival time of the trip.
     */
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the arrival time of the trip.
     *
     * @param arrivalTime The arrival time of the trip.
     */
    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns the train for the trip.
     *
     * @return The train for the trip.
     */
    public Train getTrainId() {
        return trainId;
    }

    /**
     * Sets the train for the trip.
     *
     * @param trainId The train for the trip.
     */
    public void setTrainId(Train trainId) {
        this.trainId = trainId;
    }

    /**
     * Returns the departure city of the trip.
     *
     * @return The departure city of the trip.
     */
    public City getDepartureCity() {
        return departureCity;
    }

    /**
     * Sets the departure city of the trip.
     *
     * @param departureCity The departure city of the trip.
     */
    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    /**
     * Returns the arrival city of the trip.
     *
     * @return The arrival city of the trip.
     */
    public City getArrivalCity() {
        return arrivalCity;
    }

    /**
     * Sets the arrival city of the trip.
     *
     * @param arrivalCity The arrival city of the trip.
     */
    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }
}
