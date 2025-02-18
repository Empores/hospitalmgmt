package com.empores.hospital_mgmt.controllers;

import com.empores.hospital_mgmt.models.UserProfile;
import com.empores.hospital_mgmt.services.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/registerAdmin")
    public ResponseEntity<String> registerAdmin(@RequestBody UserProfile user){
        System.out.println("register admin");
        if(registerUserService.registerAdmin(user)){
            return ResponseEntity.ok("Admin User created  successfully");
        }
        return ResponseEntity.badRequest().body("Admin already exists");
    }


    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody UserProfile user){
        System.out.println("Register user");
        if(registerUserService.registerUser(user)){
            return ResponseEntity.ok("User created successfully");
        }
        return ResponseEntity.badRequest().body("USer already exists");
    }
}
