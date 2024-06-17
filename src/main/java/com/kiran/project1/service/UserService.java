package com.kiran.project1.service;

import com.kiran.project1.model.Roles;
import com.kiran.project1.model.Users;
import com.kiran.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public Users insertUsers(Users users) {
        users.setJoinDate(LocalDate.now());
        users.setPostCount(0);
        return repository.save(users);
    }

    public List<Users> createMutipleUsers(List<Users> list){
        for(Users users: list){
            users.setJoinDate(LocalDate.now());
            users.setPostCount(0);
        }
        return repository.saveAll(list);
    }

    public List<Users> getAllusers(){
        return repository.findAll();
    }

    public Optional<Users> getById(long id){
        return repository.findById(id);
    }

    public Users updateUses(long id, Users users){
        Optional<Users> existingData = repository.findById(id);
        if(existingData.isPresent()){
            Users oldData = existingData.get();
            oldData.setUsername(users.getUsername());
            oldData.setPassword(users.getPassword());
            oldData.setEmail(users.getEmail());
            oldData.setRoles(users.getRoles());
            oldData.setWebsite(users.getWebsite());
            return repository.save(oldData);
        }
        return null;
    }

    public String deleteUsers(long id){
        repository.deleteById(id);
        return "User deleted";
    }
}
