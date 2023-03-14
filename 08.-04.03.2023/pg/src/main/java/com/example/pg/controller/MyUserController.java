package com.example.pg.controller;

import com.example.pg.model.MyUser;
import com.example.pg.repository.MyUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyUserController {
    private final MyUserRepository userRepository;

    public MyUserController(MyUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<MyUser>> getTeachers(){
        return ResponseEntity.ok(this.userRepository.findAllByRoleID(3L));
    }
    @GetMapping("/students")
    public ResponseEntity<List<MyUser>> getStudents(){
        return ResponseEntity.ok(this.userRepository.findAllByRoleID(1L));
    }
}
