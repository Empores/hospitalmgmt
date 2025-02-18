package com.empores.hospital_mgmt.services;

import com.empores.hospital_mgmt.models.Patient;
import com.empores.hospital_mgmt.models.PatientMedicalHistory;
import com.empores.hospital_mgmt.repository.PatientMedicalHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientMedicalHistoryService
{

    @Autowired
    private PatientMedicalHistoryRepo patientMedicalHistoryRepo;

    public String save(PatientMedicalHistory patientMedicalHistory){
        patientMedicalHistoryRepo.save(patientMedicalHistory);
        return "success";
    }

    public String update(PatientMedicalHistory patientMedicalHistory){
        patientMedicalHistoryRepo.save(patientMedicalHistory);
        return "success";
    }

    public String delete(Long id){
        patientMedicalHistoryRepo.deleteById(id);
        return "success";
    }

    public PatientMedicalHistory findById(Long id){
        Optional<PatientMedicalHistory> obj = patientMedicalHistoryRepo.findById(id);
        return obj.orElse(null);
    }

    public List<PatientMedicalHistory> findByPatientId(Patient patient){
       List<PatientMedicalHistory> lst = patientMedicalHistoryRepo.findByPatient(patient);
       return lst;
    }


    public List<PatientMedicalHistory> findAll(){
        return patientMedicalHistoryRepo.findAll();
    }



}
