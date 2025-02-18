package com.empores.hospital_mgmt.repository;

import com.empores.hospital_mgmt.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterUserRepo extends JpaRepository<UserProfile, Integer> {
   UserProfile findByUsername(String username);
   Optional<UserProfile> findByEmail(String email);
}
