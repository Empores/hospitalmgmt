package com.empores.hospital_mgmt.services;

import com.empores.hospital_mgmt.enums.Role;
import com.empores.hospital_mgmt.models.UserProfile;
import com.empores.hospital_mgmt.repository.RegisterUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterUserService {

    @Autowired
    private RegisterUserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(UserProfile user){
        userRepo.saveAndFlush(user);
    }

    public UserProfile getUserById(Integer userId){
       Optional<UserProfile> obj = userRepo.findById(userId);
       return obj.orElseThrow(null);
    }

    public boolean registerUser(UserProfile user){
        Optional<UserProfile> userContainer = userRepo.findByEmail(user.getEmail());
        if(userContainer.isEmpty()){
            user.setAuthorities("USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return true;
        }
        return false;
    }

    public boolean registerAdmin(UserProfile user){
        Optional<UserProfile> userContainer = userRepo.findByEmail(user.getEmail());
        if(userContainer.isEmpty()){
            user.setAuthorities("ADMIN");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            return true;
        }
        return false;
    }
}
