package com.example.traintripfx.model;

/**
 * The Train class represents a train in the train trip application.
 */
public class Train {
    private Integer id; // The ID of the train
    private Integer carCount; // The number of cars in the train
    private Integer seatsPerCar; // The number of seats per car
    private String name; // The name of the train
    private String number; // The number of the train
    private TrainType trainTypeId; // The type of the train

    /**
     * Constructs an empty Train object.
     */
    public Train() {
    }

    /**
     * Constructs a Train object with the specified parameters.
     *
     * @param trainTypeId  The type of the train.
     * @param number       The number of the train.
     * @param name         The name of the train.
     * @param carCount     The number of cars in the train.
     * @param seatsPerCar  The number of seats per car.
     */
    public Train(TrainType trainTypeId,
                 String number,
                 String name,
                 Integer carCount,
                 Integer seatsPerCar) {
        this.carCount = carCount;
        this.seatsPerCar = seatsPerCar;
        this.name = name;
        this.number = number;
        this.trainTypeId = trainTypeId;
    }

    /**
     * Returns the ID of the train.
     *
     * @return The ID of the train.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the train.
     *
     * @param id The ID of the train.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the number of cars in the train.
     *
     * @return The number of cars in the train.
     */
    public Integer getCarCount() {
        return carCount;
    }

    /**
     * Sets the number of cars in the train.
     *
     * @param carCount The number of cars in the train.
     */
    public void setCarCount(Integer carCount) {
        this.carCount = carCount;
    }

    /**
     * Returns the number of seats per car.
     *
     * @return The number of seats per car.
     */
    public Integer getSeatsPerCar() {
        return seatsPerCar;
    }

    /**
     * Sets the number of seats per car.
     *
     * @param seatsPerCar The number of seats per car.
     */
    public void setSeatsPerCar(Integer seatsPerCar) {
        this.seatsPerCar = seatsPerCar;
    }

    /**
     * Returns the name of the train.
     *
     * @return The name of the train.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the train.
     *
     * @param name The name of the train.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the number of the train.
     *
     * @return The number of the train.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the number of the train.
     *
     * @param number The number of the train.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Returns the type of the train.
     *
     * @return The type of the train.
     */
    public TrainType getTrainTypeId() {
        return trainTypeId;
    }

    /**
     * Sets the type of the train.
     *
     * @param trainTypeId The type of the train.
     */
    public void setTrainTypeId(TrainType trainTypeId) {
        this.trainTypeId = trainTypeId;
    }
}
