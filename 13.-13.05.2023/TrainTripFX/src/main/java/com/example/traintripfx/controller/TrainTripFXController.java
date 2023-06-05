package com.example.traintripfx.controller;

import com.example.traintripfx.http.HttpRequestHandler;
import com.example.traintripfx.model.Train;
import com.example.traintripfx.model.Trip;
import javafx.scene.control.TableView;

import java.util.List;

/**
 * Controller class for the TrainTripFX application.
 */
public class TrainTripFXController {
    private final TableView<Trip> tripTableView;
    private final TableView<Train> trainTableView;
    private final HttpRequestHandler httpRequestHandler;

    /**
     * Constructs a new TrainTripFXController.
     *
     * @param tripTableView  The TableView for displaying trips.
     * @param trainTableView The TableView for displaying trains.
     */
    public TrainTripFXController(TableView<Trip> tripTableView, TableView<Train> trainTableView) {
        this.tripTableView = tripTableView;
        this.trainTableView = trainTableView;
        httpRequestHandler = new HttpRequestHandler();
    }

    /**
     * Initializes the controller by fetching and displaying the trips and trains.
     */
    public void initialize() {
        fetchTrips();
        fetchTrains();
    }

    /**
     * Fetches the list of trips from the server and updates the tripTableView.
     */
    private void fetchTrips() {
        List<Trip> trips = httpRequestHandler.getAllTrips();
        updateTripTableView(trips);
    }

    /**
     * Updates the tripTableView with the provided list of trips.
     *
     * @param trips The list of trips to be displayed in the tripTableView.
     */
    private void updateTripTableView(List<Trip> trips) {
        tripTableView.getItems().clear();
        tripTableView.getItems().addAll(trips);
    }

    /**
     * Fetches the list of trains from the server and updates the trainTableView.
     */
    private void fetchTrains() {
        List<Train> trains = httpRequestHandler.getAllTrains();
        updateTrainTableView(trains);
    }

    /**
     * Updates the trainTableView with the provided list of trains.
     *
     * @param trains The list of trains to be displayed in the trainTableView.
     */
    private void updateTrainTableView(List<Train> trains) {
        trainTableView.getItems().clear();
        trainTableView.getItems().addAll(trains);
    }
}
