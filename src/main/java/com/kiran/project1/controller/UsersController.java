package com.kiran.project1.controller;

import com.kiran.project1.model.Users;
import com.kiran.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    public UserService service;

    @PostMapping("/create")
    public Users createUsers(@RequestBody Users users){
        return service.insertUsers(users);
    }

    @PostMapping("/createAll")
    public List<Users> createMutipleUsers(@RequestBody List<Users> users){
        return service.createMutipleUsers(users);
    }

    @GetMapping("/getAll")
    public List<Users> getAll(){
        return service.getAllusers();
    }

    @GetMapping("/getById/{id}")
    public Optional<Users> getById(@PathVariable long id){
        return service.getById(id);
    }


    @PutMapping("/update/{id}")
    public Users update(@PathVariable long id, @RequestBody Users users){
        return service.updateUses(id,users);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long  id){
        return service.deleteUsers(id);
    }
}
