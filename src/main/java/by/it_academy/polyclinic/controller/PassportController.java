package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.MedicalCard;
import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Role;
import by.it_academy.polyclinic.model.enumeration.Sex;
import by.it_academy.polyclinic.service.MedicalCardService;
import by.it_academy.polyclinic.service.PassportService;
import by.it_academy.polyclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("user/passport")
public class PassportController {

    private PassportService passportService;
    private UserService userService;
    private MedicalCardService medicalCardService;

    @Autowired
    public PassportController(PassportService passportService, UserService userService, MedicalCardService medicalCardService) {
        this.passportService = passportService;
        this.userService = userService;
        this.medicalCardService = medicalCardService;
    }

    @GetMapping("")
    public String getPassport(@AuthenticationPrincipal User user, Model model) {
        User userFromDb = userService.loadUserById(user.getId());
        model.addAttribute("sexValues", Sex.values());
        if (userFromDb.isUserHasPassport(userFromDb)) {
            Passport passport = userFromDb.getPassport();
            model.addAttribute("passportId", passport.getId());
            model.addAttribute("personalNo", passport.getPersonalNo());
            model.addAttribute("firstName", passport.getFirstName());
            model.addAttribute("surname", passport.getSurname());
            model.addAttribute("address", passport.getAddress());
            model.addAttribute("birthDate", passport.getBirthDate());
            model.addAttribute("birthPlace", passport.getBirthPlace());
            model.addAttribute("codeOfIssuingState", passport.getCodeOfIssuingState());
            model.addAttribute("dateOfIssue", passport.getDateOfIssue());
            model.addAttribute("dateOfExpiry", passport.getDateOfExpiry());
            model.addAttribute("nationality", passport.getNationality());
            model.addAttribute("passportNumber", passport.getPassportNumber());
            model.addAttribute("sex", passport.getSex());
            model.addAttribute("passport", passport);
        } else {
            Passport passport = new Passport();
            userFromDb.setPassport(passport);
            passport.setSex(Sex.NOT_ENTERED);
            passportService.savePassport(passport);
            model.addAttribute("passport", passport);
            MedicalCard medicalCard = new MedicalCard();
            userFromDb.setMedicalCard(medicalCard);
            medicalCardService.saveMedicalCard(medicalCard);
            if (userFromDb.getRole().equals(Role.GUEST)) {
                userFromDb.setRole(Role.PATIENT);
            }
        }

        return "passport/passport";
    }

    @PostMapping("")
    public String updatePassport(@AuthenticationPrincipal User user,
                                 @RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String surname,
                                 @RequestParam(required = false) String address,
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
                                 @RequestParam(required = false) String birthPlace,
                                 @RequestParam(required = false) String codeOfIssuingState,
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfIssue,
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfExpiry,
                                 @RequestParam(required = false) String nationality,
                                 @RequestParam(required = false) String personalNo,
                                 @RequestParam(required = false) String passportNumber,
                                 @RequestParam Sex sex
    ) {
        User userFromDb = userService.loadUserById(user.getId());
        Passport passport = userFromDb.getPassport();
        passportService.updatePassport(passport, personalNo, firstName, surname, birthDate, birthPlace, address, dateOfIssue,
                dateOfExpiry, codeOfIssuingState, nationality, passportNumber, sex);
        return "redirect:/user/profile";
    }

}
