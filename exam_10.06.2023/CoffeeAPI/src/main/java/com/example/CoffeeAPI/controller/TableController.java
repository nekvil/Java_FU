package com.example.CoffeeAPI.controller;
import com.example.CoffeeAPI.model.Table;
import com.example.CoffeeAPI.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tables")
public class TableController {
    @Autowired
    private TableService tableService;

    @GetMapping("")
    public List<Table> getAllTables(){
        return tableService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Table> get(@PathVariable Integer id){
        try{
            Table table = tableService.getTableById(id);
            return new ResponseEntity<Table>(table, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Table>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/number/{number}")
    public List<Table> getByNumber(@PathVariable String number){
        return tableService.getTableByNumber(number);
    }

    @GetMapping("/consumer/{consumer}")
    public List<Table> getByConsumer(@PathVariable String consumer){
        return tableService.getTableByConsumer(consumer);
    }


    @PostMapping("/")
    public void add(@RequestBody Table table){
        tableService.saveTable(table);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        tableService.deleteTable(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Table table, @PathVariable Integer id){
        try{
            Table baseTable = tableService.getTableById(id);
            baseTable.updateTable(table);
            tableService.saveTable(baseTable);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
