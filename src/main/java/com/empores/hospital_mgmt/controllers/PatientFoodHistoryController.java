package com.empores.hospital_mgmt.controllers;

import com.empores.hospital_mgmt.models.Patient;
import com.empores.hospital_mgmt.models.PatientFoodHistory;
import com.empores.hospital_mgmt.models.PatientMedicalHistory;
import com.empores.hospital_mgmt.services.PatientFoodHistoryService;
import com.empores.hospital_mgmt.services.PatientMedicalHistoryService;
import com.empores.hospital_mgmt.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/patientFH")
public class PatientFoodHistoryController {

    @Autowired
    private PatientFoodHistoryService patientFHService;

    @Autowired
    private PatientService patientService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping( "/index")
    public String index(Model model){
        try {
            PatientFoodHistory patientFH = new PatientFoodHistory();

            List<Patient> patientList = patientService.findAll();
            model.addAttribute("patientList", patientList);
            List<PatientFoodHistory> patientFHList = patientFHService.findAll();

            for (PatientFoodHistory obj : patientFHList) {
                if (obj != null) {
                    System.out.println(obj.getPatient().getPatientName());
                }
            }
            model.addAttribute("patientFHList", patientFHList);
            model.addAttribute("patientFH", patientFH);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "/patientFH/newPatientFH";
    }

    @GetMapping("/loadSelectedPatient/{patientId}")
    public String loadSelectedPatient(Model model,@PathVariable("patientId") String patientID) {
        try {
            Patient patient = patientService.getPatientById(Long.valueOf(patientID));
            loadList(model, patient);
            System.out.println("Patient ID::" + patientID);
            PatientFoodHistory patientFH = new PatientFoodHistory();
            patientFH.setPatient(patient);
            model.addAttribute("patientFH", patientFH);

        }catch(Exception e){
            e.printStackTrace();
        }
        return "/patientFH/newPatientFH";
    }


    @PostMapping("/savePatientFH")
    public String savePatientFH(Model model,@ModelAttribute PatientFoodHistory patientFH){
        try {
            System.out.println("Patient ID" + patientFH.getPatient());
            patientFHService.save(patientFH);
            loadList(model, patientFH.getPatient());
            model.addAttribute("patientFH", new PatientFoodHistory());

        }catch(Exception e){
            e.printStackTrace();
        }
        return "/patientFH/newPatientFH";
    }

    @GetMapping("/updateFHForm/{id}")
    public String updateFHForm(@PathVariable(value = "id") long id, Model model) {
        try {
            PatientFoodHistory patientFH = patientFHService.findById(id);
            System.out.println(patientFH.getPatient().getPatientName());
            model.addAttribute("patientFH", patientFH);
            loadList(model, patientFH.getPatient());
        }catch(Exception  e){
            e.printStackTrace();
        }
        return "patientFH/updatePatientFH";
    }

    @GetMapping("/deletePatientFH/{id}")
    public String deletePatientFH(@PathVariable(value = "id") long id,Model model) {
        try {
            PatientFoodHistory patientFH = patientFHService.findById(id);
            loadList(model, patientFH.getPatient());
            patientFHService.delete(id);
            System.out.println("patient deleted successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/patientFH/index";
    }

    //Loads patient list, patient food history list
    private void loadList(Model model, Patient patient){
        List<Patient> patientList = patientService.findAll();
        List<PatientFoodHistory> patientFHList = patientFHService.findByPatient(patient);
        model.addAttribute("patientFHList",patientFHList);
        model.addAttribute("patientList",patientList);
    }
}
