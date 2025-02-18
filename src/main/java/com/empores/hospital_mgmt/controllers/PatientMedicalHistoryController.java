package com.empores.hospital_mgmt.controllers;

import com.empores.hospital_mgmt.models.Patient;
import com.empores.hospital_mgmt.models.PatientFoodHistory;
import com.empores.hospital_mgmt.models.PatientMedicalHistory;
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
import java.util.Optional;

@RequestMapping("/patientMH")
@Controller
public class PatientMedicalHistoryController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private PatientMedicalHistoryService patientMHService;

    @Autowired
    private PatientService patientService;

    @GetMapping( "/index")
    public String index(Model model){
        try {
            PatientMedicalHistory patientMH = new PatientMedicalHistory();
            model.addAttribute("patientMH", patientMH);
            List<Patient> patientList = patientService.findAll();
            model.addAttribute("patientList", patientList);
            List<PatientMedicalHistory> patientMHList = patientMHService.findAll();
            model.addAttribute("patientMHList", patientMHList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "/patientMH/newPatientMH";
    }

    @GetMapping("/loadSelectedPatient/{patientId}")
    public String loadSelectedPatient(Model model,@PathVariable("patientId") String patientID)
    {
        try {
            Patient patient = patientService.getPatientById(Long.valueOf(patientID));
            loadList(model, patient);
            System.out.println("Patient ID::" + patientID);
            PatientMedicalHistory patientMH = new PatientMedicalHistory();
            patientMH.setPatient(patient);
            model.addAttribute("patientMH", patientMH);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "/patientMH/newPatientMH";
    }



    @PostMapping("/savePatientMH")
    public String savePatientMH(Model model,@ModelAttribute PatientMedicalHistory patientMH){
        try {
            System.out.println("Patient MH ID" + patientMH.getMhId());
            System.out.println("Patient id::" + patientMH.getPatient());
            patientMHService.save(patientMH);
            loadList(model, patientMH.getPatient());
            model.addAttribute("patientMH", new PatientMedicalHistory());
        }catch(Exception e){
            e.printStackTrace();
        }
        return "/patientMH/newPatientMH";
    }

    @GetMapping("/updateMHForm/{id}")
    public String updateMHForm(@PathVariable(value = "id") long id, Model model) {
        try {
            PatientMedicalHistory patientMH = patientMHService.findById(id);
            model.addAttribute("patientMH", patientMH);
            loadList(model, patientMH.getPatient());
        }catch(Exception e){
            e.printStackTrace();
        }
        return "patientMH/updatePatientMH";
    }

    @GetMapping("/deletePatientMH/{id}")
    public String deletePatientMH(@PathVariable(value = "id") long id,Model model) {
        try {
            PatientMedicalHistory patientMH = patientMHService.findById(id);
            loadList(model, patientMH.getPatient());
            patientMHService.delete(id);
            System.out.println("patient deleted successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
        return "/patientMH/newPatientMH";

    }

    //Loads patient list, patient medical history list
    private void loadList(Model model,Patient patient){
        List<Patient> patientList = patientService.findAll();
        List<PatientMedicalHistory> patientMHList = patientMHService.findByPatientId(patient);
        model.addAttribute("patientMHList",patientMHList);
        model.addAttribute("patientList",patientList);
    }

}
