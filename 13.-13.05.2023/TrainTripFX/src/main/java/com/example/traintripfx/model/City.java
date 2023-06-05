package com.example.traintripfx.model;

/**
 * The City class represents a city in the train trip application.
 */
public class City {
    private Integer id; // The ID of the city
    private String name; // The name of the city

    /**
     * Constructs an empty City object.
     */
    public City() {
    }

    /**
     * Constructs a City object with the specified name.
     *
     * @param name The name of the city.
     */
    public City(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the city.
     *
     * @return The ID of the city.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the city.
     *
     * @param id The ID of the city.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the name of the city.
     *
     * @return The name of the city.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the city.
     *
     * @param name The name of the city.
     */
    public void setName(String name) {
        this.name = name;
    }
}
