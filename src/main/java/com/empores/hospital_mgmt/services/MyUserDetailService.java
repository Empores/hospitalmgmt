package com.empores.hospital_mgmt.services;

import com.empores.hospital_mgmt.models.UserProfile;
import com.empores.hospital_mgmt.repository.RegisterUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private RegisterUserRepo registerUserRepo;


    @Override
    public UserProfile loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("load by username");
        return registerUserRepo.findByUsername(username);
    }
}
