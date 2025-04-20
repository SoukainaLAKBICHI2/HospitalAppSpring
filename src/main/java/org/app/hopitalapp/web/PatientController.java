package org.app.hopitalapp.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.app.hopitalapp.entities.Patient;
import org.app.hopitalapp.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/user/index")
    public String index(Model model, @RequestParam(name= "page", defaultValue = "0") int page, @RequestParam(name="size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword",defaultValue = "") String kw) {
        Page<Patient> patientPage = patientRepository.findByNomContains(kw, PageRequest.of(page,size));
        List<Patient> patientList = patientPage.getContent();
        model.addAttribute("ListPatients", patientList);
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);

        return "patient";
    }
    @GetMapping("/admin/deletePatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePatient(@RequestParam(name = "id") Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }

    @GetMapping("/admin/formPatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formPatient(Model model ){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }
    @PostMapping("/admin/savePatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "formPatient";
        }
        patientRepository.save(patient);
        return "redirect:/user/index?keyword="+patient.getNom();
    }
    @GetMapping("/admin/editPatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editPatient(@RequestParam(name = "id") Long id, Model model){
        Patient patient=patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        return "editPatient";
    }


}