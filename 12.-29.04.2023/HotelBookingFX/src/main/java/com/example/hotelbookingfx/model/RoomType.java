package com.example.hotelbookingfx.model;

public class RoomType {
    private Integer id;
    private String name;

    public RoomType() {
    }
    public RoomType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
