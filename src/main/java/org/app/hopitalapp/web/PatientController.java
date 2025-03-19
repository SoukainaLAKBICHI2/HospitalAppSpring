package org.app.hopitalapp.web;

import lombok.AllArgsConstructor;
import org.app.hopitalapp.entities.Patient;
import org.app.hopitalapp.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model) {
        List<Patient> patientList = patientRepository.findAll();
        model.addAttribute("ListPatients",patientList);
        return "patient";
    }
}