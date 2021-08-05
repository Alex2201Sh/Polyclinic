package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.Doctor;
import by.it_academy.polyclinic.model.Treatment;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Role;
import by.it_academy.polyclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("user")
public class PatientController {

    private UserService userService;
    private PassportService passportService;
    private DiseaseService diseaseService;
    private MedicalCardService medicalCardService;
    private TreatmentService treatmentService;
    private DoctorService doctorService;

    @Autowired
    public PatientController(UserService userService, PassportService passportService, DiseaseService diseaseService, MedicalCardService medicalCardService, TreatmentService treatmentService, DoctorService doctorService) {
        this.userService = userService;
        this.passportService = passportService;
        this.diseaseService = diseaseService;
        this.medicalCardService = medicalCardService;
        this.treatmentService = treatmentService;
        this.doctorService = doctorService;
    }


    @GetMapping("patient")
    public String patientDashboard(Model model, @AuthenticationPrincipal User user) {
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
        List<Treatment> treatments = userFromDb.getMedicalCard().getTreatments();
        model.addAttribute("medicalCard", userFromDb.getMedicalCard());
        model.addAttribute("doctors", userService.findUsersByRole(Role.DOCTOR));
        model.addAttribute("treatments", treatments);
        return "patientDashboard";
    }

    @GetMapping("/patient/newtreatment")
    public String addTreatmentForm(@AuthenticationPrincipal User user, Model model) {
        Treatment treatment = new Treatment();

        model.addAttribute("treatment", treatment);
        model.addAttribute("doctors", userService.findUsersByRole(Role.DOCTOR));
        return "treatmentAdd";
    }

    @PostMapping("/patient/newtreatment")
    public String addTreatment(@AuthenticationPrincipal User user, @RequestParam String sickDate, @RequestParam String doctorSurname) {
        Treatment treatment = new Treatment();
        User userFromDb = userService.loadUserById(user.getId());
        treatment.setMedicalCard(userFromDb.getMedicalCard());
        treatment.setSickDate(LocalDate.parse(sickDate));
        if (!StringUtils.isEmpty(doctorSurname)) {
            treatment.setDoctor(doctorService.loadDoctorBySurname(doctorSurname));
        } else treatment.setDoctor(null);
        treatmentService.addTreatment(treatment);
        return "redirect:/user/patient";
    }


}
