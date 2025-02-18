package com.empores.hospital_mgmt.controllers;

import com.empores.hospital_mgmt.dto.ViewPatientDTO;
import com.empores.hospital_mgmt.models.Patient;
import com.empores.hospital_mgmt.models.PatientFoodHistory;
import com.empores.hospital_mgmt.models.PatientMedicalHistory;
import com.empores.hospital_mgmt.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;




    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



    @GetMapping( "/index")
    public String index(Model model) {

        try {
            Patient patient = new Patient();
            loadList(model);
            model.addAttribute("patient", patient);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "patient/newPatient";
    }



    @PostMapping("/savePatient")
    public String savePatient(Model model,@ModelAttribute Patient patient){
        try {
            System.out.println("Patient Name" + patient.getPatientName());
            patientService.save(patient);
            model.addAttribute("patient", new Patient());
            loadList(model);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "/patient/newPatient";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        try {
            Patient patient = patientService.getPatientById(id);
            model.addAttribute("patient", patient);
            loadList(model);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "patient/updatePatient";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") long id,Model model) {
        try {

            patientService.deletePatient(id);

            System.out.println("patient deleted successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/patient/index";
    }

    @GetMapping("/getPatientById/{id}")
    public Patient getPatientById(@PathVariable("id") Long id){
        Patient patient = new Patient();
        try {
            patient =  patientService.getPatientById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return patient;
    }

    @GetMapping("/viewPatientForm/{id}")
    public String viewPatientForm(@PathVariable(value = "id") long id, Model model) {
        try {
            Patient patient = patientService.getPatientById(id);
            ViewPatientDTO patientDTO = new ViewPatientDTO();
            patientDTO.setPatient(patient);
            List<PatientMedicalHistory> lst= patient.getMedicalHistoryList();
            if(lst != null && !lst.isEmpty()) {
                patientDTO.setPatientMedicalHistory(
                        patient.getMedicalHistoryList().get(patient.getMedicalHistoryList().size()-1)
                );
            }else{
                System.out.println("Setting null");
                patientDTO.setPatientMedicalHistory(null);
            }
            model.addAttribute("patientDTO", patientDTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "view/viewPatientInfo";
    }




    //Loads patient list
    private void loadList(Model model){
        List<Patient> patientList = patientService.findAll();
        model.addAttribute("patientList",patientList);
    }

}
