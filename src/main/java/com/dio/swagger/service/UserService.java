package com.dio.swagger.service;

import com.dio.swagger.handler.RequiredFields;
import com.dio.swagger.model.User;
import com.dio.swagger.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user){
        if(user.getLogin() == null)
            throw new RequiredFields("login");
        if(user.getPassword() == null)
            throw new RequiredFields("password");
        if(user.getName() == null)
            throw new RequiredFields("name");

        return this.repository.save(user);
    }

    public void remove(Integer id){
        this.repository.findById(id).ifPresent(this.repository::delete);
    }

    public User findById(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return this.repository.findAll();
    }
}
