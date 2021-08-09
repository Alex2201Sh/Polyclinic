package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.Doctor;
import by.it_academy.polyclinic.model.Talon;
import by.it_academy.polyclinic.model.Treatment;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Role;
import by.it_academy.polyclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("user")
public class PatientController {

    private UserService userService;
    private PassportService passportService;
    private DiseaseService diseaseService;
    private MedicalCardService medicalCardService;
    private TreatmentService treatmentService;
    private DoctorService doctorService;
    private TalonService talonService;

    @Autowired
    public PatientController(UserService userService, PassportService passportService,
                             DiseaseService diseaseService, MedicalCardService medicalCardService,
                             TreatmentService treatmentService, DoctorService doctorService,
                             TalonService talonService) {
        this.userService = userService;
        this.passportService = passportService;
        this.diseaseService = diseaseService;
        this.medicalCardService = medicalCardService;
        this.treatmentService = treatmentService;
        this.doctorService = doctorService;
        this.talonService = talonService;
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
    public String addTreatmentForm(@AuthenticationPrincipal User user, Model model,
                                    @RequestParam(name = "doctor", required = false) Doctor doctor,
                                    @RequestParam(name = "talon", required = false) Talon talon

    ) {
        model.addAttribute("doctors", userService.findUsersByRole(Role.DOCTOR));
        if (doctor != null) {
            model.addAttribute("doctor", doctor);
            List<Talon> talons = doctor.getTalons();
            model.addAttribute("talons", talons);
        }
        return "treatmentAdd";
    }

    @PostMapping("/patient")
    public String addTreatment1(@AuthenticationPrincipal User user,
                                @RequestParam(name = "doctor") String doctor,
                                @RequestParam(name = "talon") String talon
    ) {
        User userFromDb = userService.loadUserById(user.getId());
        Treatment treatment = new Treatment();
        Doctor doctorFromDb = doctorService.loadDoctorById(Long.valueOf(doctor)).get();
        Talon talonFromDb = talonService.loadTalonById(Long.valueOf(talon)).get();
        talonService.deleteTalon(talonFromDb);
        treatment.setDoctor(doctorFromDb);
        treatment.setMedicalCard(userFromDb.getMedicalCard());
        treatment.setSickDate(talonFromDb.getTalonDate());
        treatmentService.addTreatment(treatment);
        return "redirect:/user/patient";
    }
}
