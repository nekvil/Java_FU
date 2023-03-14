package com.example.pg.controller;

import com.example.pg.model.Schedule;
import com.example.pg.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleController {
    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/tests")
    public ResponseEntity<List<Schedule>> getTests(){
        return ResponseEntity.ok(this.scheduleRepository.findAllByRowIDAndUserID(2L, 2L));
    }
}
