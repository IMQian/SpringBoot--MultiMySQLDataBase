package com.example.mysqls.controller;

import com.example.mysqls.entity.Boy;
import com.example.mysqls.entity2.Girl;
import com.example.mysqls.service.UserRepository;
import com.example.mysqls.service2.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepository2 userRepository2;

    @GetMapping(value = "/users")
    public List<Boy> findAllBoy(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/users2")
    public List<Girl> findAllGirl(){
        return userRepository2.findAll();
    }
}
