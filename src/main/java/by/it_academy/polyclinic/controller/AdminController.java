package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.Disease;
import by.it_academy.polyclinic.model.Doctor;
import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Department;
import by.it_academy.polyclinic.model.enumeration.Role;
import by.it_academy.polyclinic.model.enumeration.Sex;
import by.it_academy.polyclinic.service.DiseaseService;
import by.it_academy.polyclinic.service.MedicalCardService;
import by.it_academy.polyclinic.service.PassportService;
import by.it_academy.polyclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private PassportService passportService;
    private DiseaseService diseaseService;
    private MedicalCardService medicalCardService;

    @Autowired
    public AdminController(UserService userService, PassportService passportService, DiseaseService diseaseService, MedicalCardService medicalCardService) {
        this.userService = userService;
        this.passportService = passportService;
        this.diseaseService = diseaseService;
        this.medicalCardService = medicalCardService;
    }


    @GetMapping
    public String AdminDashboard() {
        return "adminDashboard";
    }

    @GetMapping("users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("users/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
        model.addAttribute("username", userFromDb.getUsername());
        model.addAttribute("email", userFromDb.getEmail());
        model.addAttribute("phoneNumber", userFromDb.getPhoneNumber());
//        model.addAttribute("password", userFromDb.getPassword());
        model.addAttribute("passport", userFromDb.getPassport());
        model.addAttribute("role", userFromDb.getRole());
        model.addAttribute("roles", Role.values());
        model.addAttribute("user", user);
        return "userEdit";
    }

    @PostMapping("users")
    public String updateProfile(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String email,
                                @RequestParam String phoneNumber,
                                @RequestParam String role) {
        User userFromDb = (User) userService.loadUserByUsername(username);
        userFromDb.setRole(Role.valueOf(role));
        userService.updateProfile(userFromDb, username, password, email, phoneNumber);
        return "redirect:/admin/users/";
    }

    @GetMapping("/users/{user}/delete")
    public String deleteUser(@PathVariable User user) {
        userService.deleteUser(user.getId());
        return "redirect:/admin/users";
    }

    @GetMapping("passports")
    public String showAllPassports(Model model) {
        model.addAttribute("passports", passportService.findAll());
        return "passport/passportList";
    }

    @GetMapping("passports/{passport}")
    public String passportEditForm(@PathVariable Passport passport, Model model) {
        model.addAttribute("firstName", passport.getFirstName());
        model.addAttribute("surname", passport.getSurname());
        model.addAttribute("address", passport.getAddress());
        model.addAttribute("birthDate", passport.getBirthDate());
        model.addAttribute("birthPlace", passport.getBirthPlace());
        model.addAttribute("dateOfIssue", passport.getDateOfIssue());
        model.addAttribute("dateOfExpiry", passport.getDateOfExpiry());
        model.addAttribute("codeOfIssuingState", passport.getCodeOfIssuingState());
        model.addAttribute("nationality", passport.getNationality());
        model.addAttribute("passportNo", passport.getPassportNumber());
        model.addAttribute("personal_no", passport.getPersonalNo());
        model.addAttribute("sex", passport.getSex());
        model.addAttribute("passportId", passport.getId());
        model.addAttribute("passport", passport);
        return "passport/passportEdit";
    }

    @PostMapping("passports")
    public String passportSave(@RequestParam String passportId, @RequestParam String personalNo, @RequestParam String firstName, @RequestParam String surname,
                               @RequestParam String birthDate, @RequestParam String birthPlace, @RequestParam String address,
                               @RequestParam String dateOfIssue, @RequestParam String dateOfExpiry, @RequestParam String codeOfIssuingState,
                               @RequestParam String nationality, @RequestParam String passportNumber, @RequestParam Sex sex) {

        Passport passportFromDb = passportService.loadPassportById(Long.valueOf(passportId)).get();
        passportFromDb.setFirstName(firstName);
        passportFromDb.setSurname(surname);
        passportFromDb.setAddress(address);
        passportFromDb.setBirthDate(LocalDate.parse(birthDate));
        passportFromDb.setBirthPlace(birthPlace);
        passportFromDb.setDateOfIssue(LocalDate.parse(dateOfIssue));
        passportFromDb.setDateOfExpiry(LocalDate.parse(dateOfExpiry));
        passportFromDb.setCodeOfIssuingState(codeOfIssuingState);
        passportFromDb.setNationality(nationality);
        passportFromDb.setPassportNumber(passportNumber);
        passportFromDb.setPersonalNo(personalNo);
        passportFromDb.setSex(sex);
        passportFromDb.setPersonalNo(personalNo);
        passportService.updatePassport(passportFromDb);
        return "redirect:/admin/passports";
    }

    @GetMapping("diseases")
    public String showAllDiseases(Model model) {
        model.addAttribute("diseases", diseaseService.findAll());
        return "diseaseList";
    }

    @GetMapping("/diseases/add")
    public String addDisease() {
        return "diseaseAdd";
    }

    @PostMapping("/diseases/add")
    public String addDiseaseToRepository(Disease disease, Model model) {

        if (!diseaseService.addDisease(disease)) {
            model.addAttribute("message", "Disease exists");
            return "diseaseAdd";
        }
        return "redirect:/admin/diseases";
    }

    @GetMapping("/diseases/{disease}")
    public String diseaseEditForm(@PathVariable Disease disease, Model model) {
        Disease diseaseFromDb = diseaseService.loadDiseaseById(disease.getId()).get();
        model.addAttribute("diseaseId", diseaseFromDb.getId().toString());
        model.addAttribute("name", diseaseFromDb.getName());
        model.addAttribute("description", diseaseFromDb.getDescription().trim());
        return "diseaseEdit";
    }

    @PostMapping("diseases")
    public String diseaseSave(
            @RequestParam String diseaseId,
            @RequestParam String name,
            @RequestParam String description) {
        Disease diseaseFromDb = diseaseService.loadDiseaseById(Long.valueOf(diseaseId)).get();
        diseaseFromDb.setName(name);
        diseaseFromDb.setDescription(description.trim());
        diseaseService.updateDisease(diseaseFromDb);
        return "redirect:/admin/diseases";
    }


}
