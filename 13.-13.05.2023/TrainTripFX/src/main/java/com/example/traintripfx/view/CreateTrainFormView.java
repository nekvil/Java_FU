package com.example.traintripfx.view;

import com.example.traintripfx.ScreenBounds;
import com.example.traintripfx.controller.CreateTrainFormController;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The CreateTrainFormView class represents the view component for creating a new train.
 * It provides a graphical user interface for entering train details and displays error messages if necessary.
 */
public class CreateTrainFormView {
    private Stage stage;
    private TextField trainTypeIdField;
    private TextField numberField;
    private TextField nameField;
    private TextField carCountField;
    private TextField seatsPerCarField;
    private CreateTrainFormController controller;

    /**
     * Sets the controller for the view.
     *
     * @param controller The controller for the view.
     */
    public void setController(CreateTrainFormController controller) {
        this.controller = controller;
    }

    /**
     * Displays the create train form view.
     *
     * @param primaryStage The primary stage of the application.
     */
    public void display(Stage primaryStage) {
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);
        stage.setTitle("Create Train");

        Label headlineLabel = new Label("Create New Train");
        headlineLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Labels
        Label trainTypeIdLabel = new Label("train_type_id:");
        Label numberLabel = new Label("number:");
        Label nameLabel = new Label("name:");
        Label carCountLabel = new Label("car_count:");
        Label seatsPerCarLabel = new Label("seats_per_car:");

        // Text fields
        trainTypeIdField = new TextField();
        numberField = new TextField();
        nameField = new TextField();
        carCountField = new TextField();
        seatsPerCarField = new TextField();

        // Create button
        Button createButton = new Button("Create");
        createButton.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        createButton.setOnAction(e -> controller.createTrain());

        // Disable create button when any required fields are empty
        createButton.disableProperty().bind(Bindings.createBooleanBinding(() ->
                        trainTypeIdField.getText().isEmpty() ||
                                numberField.getText().isEmpty() ||
                                nameField.getText().isEmpty() ||
                                carCountField.getText().isEmpty() ||
                                seatsPerCarField.getText().isEmpty(),
                trainTypeIdField.textProperty(),
                numberField.textProperty(),
                nameField.textProperty(),
                carCountField.textProperty(),
                seatsPerCarField.textProperty()));

        // GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(10, 20, 10, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Add components to GridPane
        gridPane.add(headlineLabel, 0, 0, 2, 1);
        gridPane.add(trainTypeIdLabel, 0, 1);
        gridPane.add(trainTypeIdField, 1, 1);
        gridPane.add(numberLabel, 0, 2);
        gridPane.add(numberField, 1, 2);
        gridPane.add(nameLabel, 0, 3);
        gridPane.add(nameField, 1, 3);
        gridPane.add(carCountLabel, 0, 4);
        gridPane.add(carCountField, 1, 4);
        gridPane.add(seatsPerCarLabel, 0, 5);
        gridPane.add(seatsPerCarField, 1, 5);
        gridPane.add(createButton, 0, 6, 2, 1);
        GridPane.setHalignment(createButton, javafx.geometry.HPos.RIGHT);

        // Set column and row constraints
        javafx.scene.layout.ColumnConstraints column1 = new javafx.scene.layout.ColumnConstraints();
        column1.setPercentWidth(30);
        javafx.scene.layout.ColumnConstraints column2 = new javafx.scene.layout.ColumnConstraints();
        column2.setPercentWidth(70);
        gridPane.getColumnConstraints().addAll(column1, column2);

        javafx.scene.layout.RowConstraints rowConstraints = new javafx.scene.layout.RowConstraints();
        rowConstraints.setPrefHeight(30);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints, rowConstraints);

        // BorderPane layout
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);

        // Create the scene
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);

        // Set stage size and show
        stage.setHeight(ScreenBounds.getWindowHeight(0.6));
        stage.setMinHeight(ScreenBounds.getWindowHeight(0.6));
        stage.setWidth(ScreenBounds.getWindowWidth(0.4));
        stage.setMinWidth(ScreenBounds.getWindowWidth(0.4));

        stage.showAndWait();
    }

    /**
     * Retrieves the train type ID entered in the form.
     *
     * @return The train type ID.
     */
    public Integer getTrainTypeId() {
        return Integer.parseInt(trainTypeIdField.getText());
    }

    /**
     * Retrieves the train number entered in the form.
     *
     * @return The train number.
     */
    public String getNumber() {
        return numberField.getText();
    }

    /**
     * Retrieves the train name entered in the form.
     *
     * @return The train name.
     */
    public String getName() {
        return nameField.getText();
    }

    /**
     * Retrieves the car count entered in the form.
     *
     * @return The car count.
     */
    public Integer getCarCount() {
        return Integer.parseInt(carCountField.getText());
    }

    /**
     * Retrieves the seats per car entered in the form.
     *
     * @return The seats per car.
     */
    public Integer getSeatsPerCar() {
        return Integer.parseInt(seatsPerCarField.getText());
    }

    /**
     * Closes the create train form view.
     */
    public void close() {
        stage.close();
    }

    /**
     * Displays an error message in an alert dialog.
     *
     * @param message The error message to display.
     */
    public void displayErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(stage);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
