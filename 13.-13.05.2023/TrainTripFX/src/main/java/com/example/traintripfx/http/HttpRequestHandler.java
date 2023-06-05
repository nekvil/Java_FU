package com.example.traintripfx.http;

import com.example.traintripfx.model.Train;
import com.example.traintripfx.model.Trip;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The HttpRequestHandler class handles HTTP requests for adding trains and trips,
 * retrieving all trips and trains, and parsing JSON responses.
 */
public class HttpRequestHandler {

    /**
     * The formatter for local time in the pattern "HH:mm".
     */
    public final DateTimeFormatter localTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * The formatter for local date in the pattern "dd.MM.yyyy".
     */
    public final DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * The Gson instance for JSON serialization and deserialization.
     */
    private final Gson gson;

    /**
     * Constructs a new HttpRequestHandler object.
     * Initializes the Gson instance.
     */
    public HttpRequestHandler() {
        gson = createGsonInstance();
    }

    /**
     * Adds a train by sending a POST request to the server.
     *
     * @param train The Train object to be added.
     */
    public void addTrain(Train train) {
        try {
            URL url = new URI("http://localhost:8080/trains/").toURL();
            HttpURLConnection connection = openConnection(url, "POST");
            String jsonTrain = gson.toJson(train);
            sendJsonRequest(connection, jsonTrain);
            handleResponse(connection, train.getClass().getSimpleName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds a trip by sending a POST request to the server.
     *
     * @param trip The Trip object to be added.
     */
    public void addTrip(Trip trip) {
        try {
            URL url = new URI("http://localhost:8080/trips/").toURL();
            HttpURLConnection connection = openConnection(url, "POST");
            String jsonTrip = gson.toJson(trip);
            sendJsonRequest(connection, jsonTrip);
            handleResponse(connection, trip.getClass().getSimpleName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves all trips from the server.
     *
     * @return A list of Trip objects representing all the trips.
     */
    public List<Trip> getAllTrips() {
        try {
            URL url = new URI("http://localhost:8080/trips").toURL();
            HttpURLConnection connection = openConnection(url, "GET");
            String jsonResponse = getJsonResponse(connection);
            return gson.fromJson(jsonResponse, new TypeToken<List<Trip>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    /**
     * Retrieves all trains from the server.
     *
     * @return A list of Train objects representing all the trains.
     */
    public List<Train> getAllTrains() {
        try {
            URL url = new URI("http://localhost:8080/trains").toURL();
            HttpURLConnection connection = openConnection(url, "GET");
            String jsonResponse = getJsonResponse(connection);
            return gson.fromJson(jsonResponse, new TypeToken<List<Train>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    /**
     * Opens an HTTP connection to the specified URL with the given request method.
     *
     * @param url    The URL to connect to.
     * @param method The request method (e.g., "GET", "POST").
     * @return The opened HttpURLConnection object.
     * @throws IOException If an I/O error occurs while opening the connection.
     */
    private HttpURLConnection openConnection(URL url, String method) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        return connection;
    }

    /**
     * Sends a JSON request to the server through the specified connection.
     *
     * @param connection The HttpURLConnection object.
     * @param json       The JSON request to be sent.
     * @throws IOException If an I/O error occurs while sending the request.
     */
    private void sendJsonRequest(HttpURLConnection connection, String json) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(json);
        writer.flush();
        writer.close();
    }

    /**
     * Retrieves the JSON response from the server through the specified connection.
     *
     * @param connection The HttpURLConnection object.
     * @return The JSON response received from the server.
     * @throws IOException If an I/O error occurs while reading the response.
     */
    private String getJsonResponse(HttpURLConnection connection) throws IOException {
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            return responseBuilder.toString();
        } else {
            System.out.println("Error response: " + connection.getResponseCode());
        }
        return "";
    }

    /**
     * Handles the HTTP response from the server.
     *
     * @param connection       The HttpURLConnection object.
     * @param classSimpleName The simple name of the class for which the request was made.
     */
    private void handleResponse(HttpURLConnection connection, String classSimpleName) {
        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println(classSimpleName + " created successfully");
            } else {
                System.out.println("Error response: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates and configures the Gson instance with custom serializers and deserializers.
     *
     * @return The configured Gson instance.
     */
    private Gson createGsonInstance() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, new JsonSerializer<LocalTime>() {
                    @Override
                    public JsonElement serialize(LocalTime date, Type typeOfSrc, JsonSerializationContext context) {
                        return new JsonPrimitive(date.format(localTimeFormatter));
                    }
                })
                .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                    @Override
                    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
                        return new JsonPrimitive(date.format(localDateFormatter));
                    }
                })
                .registerTypeAdapter(LocalTime.class, new JsonDeserializer<LocalTime>() {
                    @Override
                    public LocalTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalTime.parse(json.getAsJsonPrimitive().getAsString(), localTimeFormatter);
                    }
                })
                .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                    @Override
                    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), localDateFormatter);
                    }
                })
                .create();
    }
}
