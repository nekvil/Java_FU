package com.example.traintripfx.controller;

import com.example.traintripfx.http.HttpRequestHandler;
import com.example.traintripfx.model.Train;
import com.example.traintripfx.model.TrainType;
import com.example.traintripfx.view.CreateTrainFormView;

/**
 * Controller class for the create train form view.
 */
public class CreateTrainFormController {
    private CreateTrainFormView createTrainFormView;
    private final HttpRequestHandler httpRequestHandler;

    /**
     * Constructs a new CreateTrainFormController.
     */
    public CreateTrainFormController() {
        httpRequestHandler = new HttpRequestHandler();
    }

    /**
     * Sets the associated view for this controller.
     *
     * @param createTrainFormView The create train form view.
     */
    public void setView(CreateTrainFormView createTrainFormView) {
        this.createTrainFormView = createTrainFormView;
    }

    /**
     * Creates a new train based on the form input and sends an HTTP request to add the train.
     * Closes the create train form view upon successful creation.
     * Displays an error message if there are validation errors or the HTTP request fails.
     */
    public void createTrain() {
        try {
            validateFormFields();

            TrainType trainType = new TrainType();
            trainType.setId(createTrainFormView.getTrainTypeId());

            Train newTrain = new Train(
                    trainType,
                    createTrainFormView.getNumber(),
                    createTrainFormView.getName(),
                    createTrainFormView.getCarCount(),
                    createTrainFormView.getSeatsPerCar());

            httpRequestHandler.addTrain(newTrain);

            createTrainFormView.close();
        } catch (IllegalArgumentException e) {
            createTrainFormView.displayErrorMessage(e.getMessage());
        }
    }

    /**
     * Validates the form fields to ensure they contain valid values.
     * Throws an IllegalArgumentException if any of the fields are invalid.
     */
    private void validateFormFields() {
        Integer trainTypeId = createTrainFormView.getTrainTypeId();
        Integer carCount = createTrainFormView.getCarCount();
        Integer seatsPerCar = createTrainFormView.getSeatsPerCar();

        if (trainTypeId <= 0) {
            throw new IllegalArgumentException("train_type_id must be a positive integer.");
        }

        if (carCount <= 0) {
            throw new IllegalArgumentException("car_count must be a positive integer.");
        }

        if (seatsPerCar <= 0) {
            throw new IllegalArgumentException("seats_per_car must be a positive integer.");
        }
    }
}
