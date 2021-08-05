package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.Treatment;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Role;
import by.it_academy.polyclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    private UserService userService;
    private PassportService passportService;
    private DiseaseService diseaseService;
    private MedicalCardService medicalCardService;
    private TreatmentService treatmentService;

    @Autowired
    public DoctorController(UserService userService, PassportService passportService, DiseaseService diseaseService, MedicalCardService medicalCardService, TreatmentService treatmentService) {
        this.userService = userService;
        this.passportService = passportService;
        this.diseaseService = diseaseService;
        this.medicalCardService = medicalCardService;
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public String doctorDashboard() {
        return "doctorDashboard";
    }

    @GetMapping("patients")
    public String showAllPatients(@AuthenticationPrincipal User user, Model model) {
        User userFromDb = userService.loadUserById(user.getId());
        List<Treatment> treatmentsByDoctor = treatmentService.findByDoctor(userFromDb.getDoctor());
        List<Treatment> treatmentsWithoutDoctor = treatmentService.findWithoutDoctor();
        boolean isUserADoctor = userFromDb.getRole().equals(Role.DOCTOR);
        model.addAttribute("isUserADoctor",isUserADoctor);
        model.addAttribute("patients", userService.findUsersByRole(Role.PATIENT));
        model.addAttribute("guests", userService.findUsersByRole(Role.GUEST));
        model.addAttribute("treatments", treatmentsByDoctor);
        model.addAttribute("treatmentsWoDoctor", treatmentsWithoutDoctor);
        return "doctorUserList";
    }


}
