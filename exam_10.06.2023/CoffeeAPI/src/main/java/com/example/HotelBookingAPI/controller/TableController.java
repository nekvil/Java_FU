package com.example.HotelBookingAPI.controller;
import com.example.HotelBookingAPI.model.Table;
import com.example.HotelBookingAPI.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tables")
public class TableController {
    @Autowired
    private TableService clientService;

    @GetMapping("")
    public List<Table> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Table> get(@PathVariable Integer id){
        try{
            Table table = clientService.getClientById(id);
            return new ResponseEntity<Table>(table, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Table>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/last-name/{lastName}")
    public List<Table> getByLastName(@PathVariable String lastName){
        return clientService.getClientByLastName(lastName);
    }

    @GetMapping("/first-name/{firstName}")
    public List<Table> getByFirstName(@PathVariable String firstName){
        return clientService.getClientByFirstName(firstName);
    }

    @GetMapping("/middle-name/{middleName}")
    public List<Table> getByMiddleName(@PathVariable String middleName){
        return clientService.getClientByMiddleName(middleName);
    }

    @GetMapping("/date-of-birth/{dateOfBirth}")
    public List<Table> getByDateOfBirth(@PathVariable LocalDate dateOfBirth){
        return clientService.getClientByDateOfBirth(dateOfBirth);
    }

    @PostMapping("/")
    public void add(@RequestBody Table city){
        clientService.saveClient(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Table table, @PathVariable Integer id){
        try{
            Table baseTable = clientService.getClientById(id);
            baseTable.updateClient(table);
            clientService.saveClient(baseTable);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
