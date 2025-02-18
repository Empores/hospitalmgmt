package com.empores.hospital_mgmt.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class PatientMedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mhId;

    @ManyToOne
    @JoinColumn(name="patientId", referencedColumnName = "patient_id")
    private Patient patient;

    private Date dateTime;


    private Double height;
    private Double weight;
    private Double bmi;

    private Integer systolic;
    private Integer diastolic;

    private Integer ldlValue;
    private Integer hdlValue;
    private Integer totalchl;
    private Integer triglycerides;

    private Integer fastingSugar;
    private Integer postMealSugar;
    private Double hbalc;
    private Double homaIndex;

    private String notes;

    public Long getMhId() {
        return mhId;
    }

    public void setMhId(Long mhId) {
        this.mhId = mhId;
    }



    public Date getDateTime() {
        return dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public Integer getLdlValue() {
        return ldlValue;
    }

    public void setLdlValue(Integer ldlValue) {
        this.ldlValue = ldlValue;
    }

    public Integer getHdlValue() {
        return hdlValue;
    }

    public void setHdlValue(Integer hdlValue) {
        this.hdlValue = hdlValue;
    }

    public Integer getFastingSugar() {
        return fastingSugar;
    }

    public void setFastingSugar(Integer fastingSugar) {
        this.fastingSugar = fastingSugar;
    }

    public Integer getPostMealSugar() {
        return postMealSugar;
    }

    public void setPostMealSugar(Integer postMealSugar) {
        this.postMealSugar = postMealSugar;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Integer getTotalchl() {
        return totalchl;
    }

    public void setTotalchl(Integer totalchl) {
        this.totalchl = totalchl;
    }

    public Integer getTriglycerides() {
        return triglycerides;
    }

    public void setTriglycerides(Integer triglycerides) {
        this.triglycerides = triglycerides;
    }

    public Double getHbalc() {
        return hbalc;
    }

    public void setHbalc(Double hbalc) {
        this.hbalc = hbalc;
    }

    public Double getHomaIndex() {
        return homaIndex;
    }

    public void setHomaIndex(Double homaIndex) {
        this.homaIndex = homaIndex;
    }
}
