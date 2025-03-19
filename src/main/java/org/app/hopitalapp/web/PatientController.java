package org.app.hopitalapp.web;

import lombok.AllArgsConstructor;
import org.app.hopitalapp.entities.Patient;
import org.app.hopitalapp.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name= "page", defaultValue = "0") int page, @RequestParam(name="size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String kw) {
        Page<Patient> patientPage = patientRepository.findAll(PageRequest.of(page, size));

        List<Patient> patientList = patientPage.getContent();
        model.addAttribute("ListPatients", patientList);
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);

        return "patient";
    }
}