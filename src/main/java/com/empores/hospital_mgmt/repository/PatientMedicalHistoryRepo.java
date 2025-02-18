package com.empores.hospital_mgmt.repository;

import com.empores.hospital_mgmt.models.Patient;
import com.empores.hospital_mgmt.models.PatientMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientMedicalHistoryRepo extends JpaRepository<PatientMedicalHistory, Long> {


    List<PatientMedicalHistory> findByPatient(Patient patient);

}
