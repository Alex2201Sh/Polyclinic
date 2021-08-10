package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.*;
import by.it_academy.polyclinic.model.enumeration.Department;
import by.it_academy.polyclinic.model.enumeration.Role;
import by.it_academy.polyclinic.model.enumeration.Sex;
import by.it_academy.polyclinic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private PassportService passportService;
    private DiseaseService diseaseService;
    private MedicalCardService medicalCardService;
    private PasswordEncoder passwordEncoder;
    private DoctorService doctorService;
    private TalonService talonService;

    @Autowired
    public AdminController(UserService userService, PassportService passportService,
                           DiseaseService diseaseService,
                           MedicalCardService medicalCardService,
                           PasswordEncoder passwordEncoder, DoctorService doctorService,
                           TalonService talonService) {
        this.userService = userService;
        this.passportService = passportService;
        this.diseaseService = diseaseService;
        this.medicalCardService = medicalCardService;
        this.passwordEncoder = passwordEncoder;
        this.doctorService = doctorService;
        this.talonService = talonService;
    }

    @GetMapping
    public String AdminDashboard(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("passports", passportService.findAll());
        model.addAttribute("doctors", userService.findUsersByRole(Role.DOCTOR));
        model.addAttribute("diseases", diseaseService.findAll());

        return "admin/adminDashboard";
    }

    @GetMapping("users")
    public String showAllUsers(Model model,
                               @PageableDefault(sort = {"username"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<User> page;
        page = userService.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "users");

        return "admin/userList";
    }

    @GetMapping("users/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
        model.addAttribute("username", userFromDb.getUsername());
        model.addAttribute("email", userFromDb.getEmail());
        model.addAttribute("phoneNumber", userFromDb.getPhoneNumber());
        model.addAttribute("passport", userFromDb.getPassport());
        model.addAttribute("role", userFromDb.getRole());
        model.addAttribute("roles", Role.values());
        model.addAttribute("user", userFromDb);
        return "admin/userEdit";
    }

    @PostMapping("users")
    public String updateProfile(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String role,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String cabinet,
            RedirectAttributes redirectAttributes) {
        User userFromDb = (User) userService.loadUserByUsername(username);
        if (!StringUtils.isEmpty(password)) {
            userFromDb.setPassword(passwordEncoder.encode(password));
        }
        if (!StringUtils.isEmpty(email)) {
            userFromDb.setEmail(email);
        }
        if (!StringUtils.isEmpty(phoneNumber)) {
            userFromDb.setPhoneNumber(phoneNumber);
        }
        if (!StringUtils.isEmpty(role)) {
            userFromDb.setRole(Role.valueOf(role));
        }

        if (role.equals("DOCTOR")) {
            if (userFromDb.getDoctor() != null) {
                Doctor doctor = userFromDb.getDoctor();
                if (!StringUtils.isEmpty(position)) {
                    doctor.setPosition(position);
                }
                if (!StringUtils.isEmpty(department)) {
                    doctor.setDepartment(Department.valueOf(department));
                }
                if (!StringUtils.isEmpty(cabinet)) {
                    doctor.setCabinet(cabinet);
                }
                doctorService.updateDoctor(doctor);
            } else {
                Doctor doctor = new Doctor();
                if (!StringUtils.isEmpty(position)) {
                    doctor.setPosition(position);
                }
                if (!StringUtils.isEmpty(department)) {
                    doctor.setDepartment(Department.valueOf(department));
                }
                if (!StringUtils.isEmpty(cabinet)) {
                    doctor.setCabinet(cabinet);
                }
                userFromDb.setDoctor(doctor);
                doctorService.addDoctor(doctor);
            }
        }
        userService.updateProfile(userFromDb);
        redirectAttributes.addAttribute("id", userFromDb.getId());
        return "redirect:/admin/users/{id}";
    }

    @GetMapping("/users/{user}/delete")
    public String deleteUser(@PathVariable User user) {
        userService.deleteUser(user.getId());
        return "redirect:/admin/users";
    }

    @GetMapping("passports")
    public String showAllPassports(Model model,
                                   @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Passport> page;
        page = passportService.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "passports");
        return "admin/passportList";
    }

    @GetMapping("passports/{passport}")
    public String passportEditForm(@PathVariable Passport passport, Model model) {
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
    public String showAllDiseases(Model model,
                                  @PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Disease> page;
        page = diseaseService.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "diseases");
//        model.addAttribute("diseases", diseaseService.findAll());
        return "admin/diseaseList";
    }

    @GetMapping("/diseases/add")
    public String addDisease() {
        return "disease/diseaseAdd";
    }

    @PostMapping("/diseases/add")
    public String addDiseaseToRepository(Disease disease, Model model) {

        if (!diseaseService.addDisease(disease)) {
            model.addAttribute("message", "Disease exists");
            return "disease/diseaseAdd";
        }
        return "redirect:/admin/diseases";
    }

    @GetMapping("/diseases/{disease}")
    public String diseaseEditForm(@PathVariable Disease disease, Model model) {
        Disease diseaseFromDb = diseaseService.loadDiseaseById(disease.getId());
        model.addAttribute("diseaseId", diseaseFromDb.getId().toString());
        model.addAttribute("name", diseaseFromDb.getName());
        model.addAttribute("description", diseaseFromDb.getDescription().trim());
        return "disease/diseaseEdit";
    }

    @PostMapping("diseases")
    public String diseaseSave(
            @RequestParam String diseaseId,
            @RequestParam String name,
            @RequestParam String description) {
        Disease diseaseFromDb = diseaseService.loadDiseaseById(Long.valueOf(diseaseId));
        diseaseFromDb.setName(name);
        diseaseFromDb.setDescription(description.trim());
        diseaseService.updateDisease(diseaseFromDb);
        return "redirect:/admin/diseases";
    }

    @GetMapping("/diseases/{disease}/delete")
    public String deleteUser(@PathVariable Disease disease) {
        diseaseService.deleteDisease(disease.getId());
        return "redirect:/admin/diseases";

    }

    @GetMapping("talons")
    public String talonsAdd(Model model,
                            @RequestParam(name = "doctor", required = false) Doctor doctor) {
        model.addAttribute("doctors", userService.findUsersByRole(Role.DOCTOR));
        if (doctor != null) {
            model.addAttribute("doctor", doctor);
        }
        return "admin/talonsAdd";
    }

    @PostMapping("talons")
    public String talondAdd(@RequestParam(name = "doctor") String doctor,
                            @RequestParam String date) {
        Doctor doctorFromDb = doctorService.loadDoctorById(Long.valueOf(doctor)).get();
        List<Talon> talonList = new ArrayList<>();
        for (int i = 8; i < 16; i++) {
            Talon talon = new Talon();
            talon.setDoctor(doctorFromDb);
            talon.setTalonDate(LocalDate.parse(date));
            talon.setTalonTime(i+":00");
            talonList.add(talon);
            talonService.addTalon(talon);
        }
        doctorFromDb.setTalons(talonList);
        return "redirect:/admin/users";
    }
}
