package com.example.HotelBookingAPI.repository;

import com.example.HotelBookingAPI.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TableRepository extends JpaRepository<Table, Integer> {
    List<Table> findByLastName(String lastName);
    List<Table> findByFirstName(String firstName);
    List<Table> findByMiddleName(String middleName);
    List<Table> findByDateOfBirth(LocalDate dateOfBirth);
}
