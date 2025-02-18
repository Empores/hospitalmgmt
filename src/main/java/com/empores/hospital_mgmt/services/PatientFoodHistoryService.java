package com.empores.hospital_mgmt.services;

import com.empores.hospital_mgmt.models.Patient;
import com.empores.hospital_mgmt.models.PatientFoodHistory;
import com.empores.hospital_mgmt.models.PatientMedicalHistory;
import com.empores.hospital_mgmt.repository.PatientFoodHistoryRepo;
import com.empores.hospital_mgmt.repository.PatientMedicalHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientFoodHistoryService
{

    @Autowired
    private PatientFoodHistoryRepo patientFoodHistoryRepo;

    public String save(PatientFoodHistory patientFoodHistory){
        patientFoodHistoryRepo.save(patientFoodHistory);
        return "success";
    }

    public String update(PatientFoodHistory patientFoodHistory){
        patientFoodHistoryRepo.save(patientFoodHistory);
        return "success";
    }

    public String delete(Long id){
        patientFoodHistoryRepo.deleteById(id);
        return "success";
    }

    public PatientFoodHistory findById(Long id){
        Optional<PatientFoodHistory> obj = patientFoodHistoryRepo.findById(id);
        return obj.orElse(null);
    }

    public List<PatientFoodHistory> findAll(){
        return patientFoodHistoryRepo.findAll();
    }

    public List<PatientFoodHistory> findByPatient(Patient patient){
        List<PatientFoodHistory> lst = patientFoodHistoryRepo.findByPatient(patient);
        return lst;
    }



}
