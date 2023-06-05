package com.example.traintripfx;

import com.example.traintripfx.controller.CreateTrainFormController;
import com.example.traintripfx.controller.CreateTripFormController;
import com.example.traintripfx.controller.TrainTripFXController;
import com.example.traintripfx.model.Train;
import com.example.traintripfx.model.Trip;
import com.example.traintripfx.view.CreateTrainFormView;
import com.example.traintripfx.view.CreateTripFormView;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * The main class for the Train Trip application.
 * This class extends the JavaFX Application class and serves as the entry point for the application.
 * It initializes and configures the user interface, including the main window and its components.
 */
public class TrainTripFXApplication extends Application {
    private Stage primaryStage;
    private TrainTripFXController trainTripFXController;

    /**
     * The entry point for the JavaFX application.
     * It launches the JavaFX runtime and calls the start() method.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes and configures the main window of the application.
     * This method sets up the UI components, such as tables and tabs, and displays the main window.
     *
     * @param primaryStage The primary stage of the JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Train Trip App");

        TableView<Trip> tripTableView = createTripTable();
        TableView<Train> trainTableView = createTrainTable();

        trainTripFXController = new TrainTripFXController(tripTableView, trainTableView);
        trainTripFXController.initialize();

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setTabMinWidth(100);

        Tab tripTab = createTab("Trips", "Trips", tripTableView, this::openCreateTripForm);
        tabPane.getTabs().add(tripTab);

        Tab trainTab = createTab("Trains", "Trains", trainTableView, this::openCreateTrainForm);
        tabPane.getTabs().add(trainTab);

        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);

        primaryStage.setHeight(ScreenBounds.getWindowHeight(0.65));
        primaryStage.setMinHeight(ScreenBounds.getWindowHeight(0.65));
        primaryStage.setWidth(ScreenBounds.getWindowWidth(0.65));
        primaryStage.setMinWidth(ScreenBounds.getWindowWidth(0.65));

        primaryStage.show();
    }

    /**
     * Creates the header box for a tab.
     * The header box includes a label and a button for adding new items to the table.
     *
     * @param label The label to display in the header box.
     * @param button The button for adding new items.
     * @return The created header box.
     */
    private HBox createHeaderBox(Label label, Button button) {
        label.setFont(Font.font("System", FontWeight.BOLD, 18));

        HBox headerBox = new HBox(10);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.getChildren().add(label);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(buttonBox, Priority.ALWAYS);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        button.setFont(Font.font("System", FontWeight.BOLD, 14));

        buttonBox.getChildren().addAll(spacer, button);
        headerBox.getChildren().add(buttonBox);

        return headerBox;
    }

    /**
     * Creates a tab for a specific table.
     * The tab contains the table view and a header box with a label and an add button.
     *
     * @param tabTitle The title of the tab.
     * @param headerLabelText The text to display in the header label.
     * @param tableView The table view to display in the tab.
     * @param addButtonAction The action to execute when the add button is clicked.
     * @return The created tab.
     */
    private Tab createTab(String tabTitle, String headerLabelText, TableView<?> tableView, Runnable addButtonAction) {
        VBox tabVBox = new VBox(10);
        tabVBox.setPadding(new Insets(20));

        Label headerLabel = new Label(headerLabelText);
        Button addButton = new Button("+ Add New");
        addButton.setOnAction(e -> addButtonAction.run());
        HBox headerBox = createHeaderBox(headerLabel, addButton);

        tabVBox.getChildren().addAll(headerBox, tableView);
        VBox.setVgrow(tableView, Priority.ALWAYS);

        Tab tab = new Tab(tabTitle);
        tab.setContent(tabVBox);

        return tab;
    }

    /**
     * Creates a table view for displaying trips.
     * The table view is configured with columns for various trip properties.
     *
     * @return The created trip table view.
     */
    private TableView<Trip> createTripTable() {
        TableView<Trip> table = new TableView<>();

        TableColumn<Trip, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(data ->  new SimpleIntegerProperty(data.getValue().getId()).asObject());

        TableColumn<Trip, Integer> trainIdColumn = new TableColumn<>("train_id");
        trainIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTrainId().getId()));

        TableColumn<Trip, Integer> departureCityIdColumn = new TableColumn<>("departure_city");
        departureCityIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDepartureCity().getId()));

        TableColumn<Trip, LocalDate> departureDateColumn = new TableColumn<>("departure_date");
        departureDateColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDepartureDate()));

        TableColumn<Trip, LocalTime> departureTimeColumn = new TableColumn<>("departure_time");
        departureTimeColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDepartureTime()));

        TableColumn<Trip, Integer> arrivalCityIdColumn = new TableColumn<>("arrival_city");
        arrivalCityIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getArrivalCity().getId()));

        TableColumn<Trip, LocalDate> arrivalDateColumn = new TableColumn<>("arrival_date");
        arrivalDateColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getArrivalDate()));

        TableColumn<Trip, LocalTime> arrivalTimeColumn = new TableColumn<>("arrival_time");
        arrivalTimeColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getArrivalTime()));

        TableColumn<Trip, Integer> availableSeatsColumn = new TableColumn<>("available_seats");
        availableSeatsColumn.setCellValueFactory(data ->  new SimpleIntegerProperty(data.getValue().getAvailableSeats()).asObject());

        TableColumn<Trip, Integer> totalSeatsColumn = new TableColumn<>("total_seats");
        totalSeatsColumn.setCellValueFactory(data ->  new SimpleIntegerProperty(data.getValue().getTotalSeats()).asObject());

        TableColumn<Trip, Double> basePriceColumn = new TableColumn<>("base_price");
        basePriceColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getBasePrice()).asObject());

        List<TableColumn<Trip, ?>> columns = Arrays.asList(
                idColumn,
                trainIdColumn,
                departureCityIdColumn,
                departureDateColumn,
                departureTimeColumn,
                arrivalCityIdColumn,
                arrivalDateColumn,
                arrivalTimeColumn,
                availableSeatsColumn,
                totalSeatsColumn,
                basePriceColumn
                );
        table.getColumns().addAll(columns);

        return table;
    }

    /**
     * Creates a table view for displaying trains.
     * The table view is configured with columns for various train properties.
     *
     * @return The created train table view.
     */
    private TableView<Train> createTrainTable() {
        TableView<Train> table = new TableView<>();

        TableColumn<Train, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());

        TableColumn<Train, String> numberColumn = new TableColumn<>("number");
        numberColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNumber()));

        TableColumn<Train, String> nameColumn = new TableColumn<>("name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Train, Integer> trainTypeIdColumn = new TableColumn<>("train_type_id");
        trainTypeIdColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getTrainTypeId().getId()));

        TableColumn<Train, Integer> carCountColumn = new TableColumn<>("car_count");
        carCountColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getCarCount()).asObject());

        TableColumn<Train, Integer> seatsPerCarColumn = new TableColumn<>("seats_per_car");
        seatsPerCarColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getSeatsPerCar()).asObject());

        List<TableColumn<Train, ?>> columns = Arrays.asList(
                idColumn,
                numberColumn,
                nameColumn,
                trainTypeIdColumn,
                carCountColumn,
                seatsPerCarColumn
        );

        table.getColumns().addAll(columns);

        return table;
    }

    /**
     * Opens the create trip form.
     * This method is called when the user clicks the add new button in the trip tab.
     * It disables the main window, displays the create trip form, and enables the main window afterward.
     */
    private void openCreateTripForm() {
        primaryStage.getScene().getRoot().setDisable(true);

        CreateTripFormController createTripFormController = new CreateTripFormController();
        CreateTripFormView createTripFormView = new CreateTripFormView();

        createTripFormController.setView(createTripFormView);
        createTripFormView.setController(createTripFormController);

        createTripFormView.display(primaryStage);
        enableMainWindow();
    }

    /**
     * Opens the create train form.
     * This method is called when the user clicks the add new button in the train tab.
     * It disables the main window, displays the create train form, and enables the main window afterward.
     */
    private void openCreateTrainForm() {
        primaryStage.getScene().getRoot().setDisable(true);

        CreateTrainFormController createTrainFormController = new CreateTrainFormController();
        CreateTrainFormView createTrainFormView = new CreateTrainFormView();

        createTrainFormController.setView(createTrainFormView);
        createTrainFormView.setController(createTrainFormController);

        createTrainFormView.display(primaryStage);
        enableMainWindow();
    }

    /**
     * Enables the main window after a sub-window is closed.
     * This method is called when a sub-window (create trip form or create train form) is closed.
     * It re-enables the main window and re-initializes the controller and UI components.
     */
    public void enableMainWindow() {
        primaryStage.getScene().getRoot().setDisable(false);
        primaryStage.getScene().getWindow().setOpacity(1.0);
        trainTripFXController.initialize();
    }
}
