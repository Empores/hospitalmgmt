package com.empores.hospital_mgmt.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class PatientFoodHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fhId;

    @ManyToOne
    @JoinColumn(name="patientId", referencedColumnName = "patient_id")
    private Patient patient;

    private Date date;
    private String breakfast;
    private String lunch;
    private String dinner;
    private String notes;

    public Integer getFhId() {
        return fhId;
    }

    public void setFhId(Integer fhId) {
        this.fhId = fhId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
