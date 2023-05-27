package com.example.moviehubfx;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    private TableView<Movie> movieTableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        movieTableView = createMovieTable();

        fetchReservations();

        VBox vbox = new VBox(10);
        vbox.getChildren().add(movieTableView);

        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setTitle("Movie Hub App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableView<Movie> createMovieTable() {
        TableView<Movie> table = new TableView<>();

        TableColumn<Movie, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(data ->  new SimpleIntegerProperty(data.getValue().getId()).asObject());

        TableColumn<Movie, String> nameColumn = new TableColumn<>("name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Movie, String> genreColumn = new TableColumn<>("genre");
        genreColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGenre()));

        TableColumn<Movie, Integer> durationColumn = new TableColumn<>("duration");
        durationColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getDuration()).asObject());

        TableColumn<Movie, Integer> releaseColumn = new TableColumn<>("release");
        releaseColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getRelease()).asObject());

        table.getColumns().addAll(idColumn, nameColumn, genreColumn, durationColumn, releaseColumn);

        return table;
    }

    private void fetchReservations() {
        try {
            URL url = new URL("http://localhost:8080/movies");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseBuilder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }

                reader.close();

                Gson gson = new Gson();
                Type reservationListType = new TypeToken<List<Movie>>(){}.getType();
                
                System.out.println(responseBuilder.toString());

                ArrayList<Movie> bookings = gson.fromJson(responseBuilder.toString(), reservationListType);
                movieTableView.getItems().addAll(bookings);
            } else {
                System.out.println("Error response: " + connection.getResponseCode());
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Movie {


        private Integer id, duration, release;

        private String name, genre;


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public Integer getRelease() {
            return release;
        }

        public void setRelease(Integer release) {
            this.release = release;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }
    }
}