package com.example.CoffeeAPI.service;

import com.example.CoffeeAPI.model.Table;
import com.example.CoffeeAPI.repository.TableRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public List<Table> getAllTables(){
        return tableRepository.findAll();
    }

    public List<Table> getTableByNumber(String number){
        return tableRepository.findByNumber(number);
    }

    public List<Table> getTableByConsumer(String consumer){
        return tableRepository.findByConsumer(consumer);
    }

    public void saveTable(Table table){
        tableRepository.save(table);
    }

    public void deleteTable(Integer id){
        tableRepository.deleteById(id);
    }

    public Table getTableById(Integer id){
        return tableRepository.findById(id).orElse(null);
    }
}
