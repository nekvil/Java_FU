package com.example.traintripfx.model;

/**
 * The TrainType class represents a type of train in the train trip application.
 */
public class TrainType {
    private Integer id; // The ID of the train type
    private String name; // The name of the train type

    /**
     * Constructs an empty TrainType object.
     */
    public TrainType() {
    }

    /**
     * Constructs a TrainType object with the specified name.
     *
     * @param name The name of the train type.
     */
    public TrainType(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the train type.
     *
     * @return The ID of the train type.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the train type.
     *
     * @param id The ID of the train type.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the name of the train type.
     *
     * @return The name of the train type.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the train type.
     *
     * @param name The name of the train type.
     */
    public void setName(String name) {
        this.name = name;
    }
}
