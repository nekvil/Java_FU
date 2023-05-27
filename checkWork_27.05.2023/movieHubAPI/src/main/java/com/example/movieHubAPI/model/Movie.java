package com.example.movieHubAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity(name="movie")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name, genre;
    private Integer duration, release;

    public void updateMovie(Movie movie){
        if(movie.name != null){
            this.name = movie.name;
        }
        if(movie.genre != null){
            this.genre = movie.genre;
        }
        if(movie.duration != null){
            this.duration = movie.duration;
        }
        if(movie.release != null){
            this.release = movie.release;
        }
    }
}
