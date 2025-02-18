package com.empores.hospital_mgmt.services;

import com.empores.hospital_mgmt.models.Patient;
import com.empores.hospital_mgmt.repository.PatientFoodHistoryRepo;
import com.empores.hospital_mgmt.repository.PatientMedicalHistoryRepo;
import com.empores.hospital_mgmt.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService  {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private PatientMedicalHistoryRepo patientMedicalHistoryRepo;

    @Autowired
    private PatientFoodHistoryRepo patientFoodHistoryRepo;

    public String save(Patient patient){
        patient = patientRepo.save(patient);
        return "Success";
    }

    public String update(Patient patient){
        patient = patientRepo.save(patient);
        return "Success";
    }

    public Patient getPatientById(Long patientId){
        Optional<Patient> obj = patientRepo.findById(patientId);
        return obj.orElse(null);
    }


    public List<Patient> findAll(){
        return patientRepo.findAll();
    }


    public Page<Patient> findAll(Pageable paging){
        return patientRepo.findAll(paging);
    }

    public Page<Patient> findByPatientNameContainingIgnoreCase(String keyword,Pageable paging){
        return patientRepo.findByPatientNameContainingIgnoreCase(keyword,paging);
    }
    public void deletePatient(Long patientId){
        Patient patient = getPatientById(patientId);
        System.out.println("Patient :::"+patient);
        patientRepo.deleteById(patientId);
    }
}
