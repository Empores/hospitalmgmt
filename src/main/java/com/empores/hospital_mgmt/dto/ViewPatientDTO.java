package com.empores.hospital_mgmt.dto;

import com.empores.hospital_mgmt.models.Patient;
import com.empores.hospital_mgmt.models.PatientFoodHistory;
import com.empores.hospital_mgmt.models.PatientMedicalHistory;
import org.springframework.stereotype.Component;

@Component
public class ViewPatientDTO {

    private Patient patient;
    private PatientMedicalHistory patientMedicalHistory;
    private PatientFoodHistory patientFoodHistory;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientMedicalHistory getPatientMedicalHistory() {
        return patientMedicalHistory;
    }

    public void setPatientMedicalHistory(PatientMedicalHistory patientMedicalHistory) {
        this.patientMedicalHistory = patientMedicalHistory;
    }

    public PatientFoodHistory getPatientFoodHistory() {
        return patientFoodHistory;
    }

    public void setPatientFoodHistory(PatientFoodHistory patientFoodHistory) {
        this.patientFoodHistory = patientFoodHistory;
    }
}
