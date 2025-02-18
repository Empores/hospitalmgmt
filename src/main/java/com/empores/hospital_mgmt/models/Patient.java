package com.empores.hospital_mgmt.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="patient")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private Long patientId;
    @Column(name="name")
    private String patientName;
    @Column(name="dob")
    private Date dob;
    @Column(name="phone_no")
    private String phoneNo;
    @Column(name="email_id")
    private String emailId;
    private String address;
    private String notes;
    private String sex;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<PatientFoodHistory> foodHistorySet;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<PatientMedicalHistory> medicalHistoryList;



    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<PatientFoodHistory> getFoodHistorySet() {
        return foodHistorySet;
    }

    public void setFoodHistorySet(List<PatientFoodHistory> foodHistorySet) {
        this.foodHistorySet = foodHistorySet;
    }

    public List<PatientMedicalHistory> getMedicalHistoryList() {
        return medicalHistoryList;
    }

    public void setMedicalHistoryList(List<PatientMedicalHistory> medicalHistoryList) {
        this.medicalHistoryList = medicalHistoryList;
    }
}
