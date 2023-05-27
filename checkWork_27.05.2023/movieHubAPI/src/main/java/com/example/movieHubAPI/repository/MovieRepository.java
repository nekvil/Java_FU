package com.example.movieHubAPI.repository;

import com.example.movieHubAPI.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByName(String name);
    List<Movie> findByGenre(String genre);
    List<Movie> findByDuration(Integer duration);
    List<Movie> findByRelease(Integer release);
}
