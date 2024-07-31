package com.dio.swagger.controller;

import com.dio.swagger.model.User;
import com.dio.swagger.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> finById(@PathVariable Integer id){
        return ResponseEntity.ok(this.service.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(this.service.save(user));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(this.service.save(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable Integer id){
        this.service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
