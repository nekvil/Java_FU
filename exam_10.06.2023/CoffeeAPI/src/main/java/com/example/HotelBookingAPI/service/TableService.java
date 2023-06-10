package com.example.HotelBookingAPI.service;

import com.example.HotelBookingAPI.model.Table;
import com.example.HotelBookingAPI.repository.TableRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public List<Table> getAllClients(){
        return tableRepository.findAll();
    }

    public List<Table> getClientByLastName(String lastName){
        return tableRepository.findByLastName(lastName);
    }

    public List<Table> getClientByFirstName(String firstName){
        return tableRepository.findByFirstName(firstName);
    }

    public List<Table> getClientByMiddleName(String middleName){
        return tableRepository.findByMiddleName(middleName);
    }

    public List<Table> getClientByDateOfBirth(LocalDate dateOfBirth){
        return tableRepository.findByDateOfBirth(dateOfBirth);
    }

    public void saveClient(Table table){
        tableRepository.save(table);
    }

    public void deleteClient(Integer id){
        tableRepository.deleteById(id);
    }

    public Table getClientById(Integer id){
        return tableRepository.findById(id).orElse(null);
    }
}
