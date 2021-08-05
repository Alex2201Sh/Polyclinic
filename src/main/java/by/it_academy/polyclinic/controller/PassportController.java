package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Sex;
import by.it_academy.polyclinic.service.PassportService;
import by.it_academy.polyclinic.service.UserService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("user/passport")
public class PassportController {

    private PassportService passportService;
    private UserService userService;

    public PassportController(PassportService passportService, UserService userService) {
        this.passportService = passportService;
        this.userService = userService;
    }

    @GetMapping("")
    public String getPassport(@AuthenticationPrincipal User user, Model model) {
        User userFromDb = userService.loadUserById(user.getId());
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
        } else {
            Passport passport = new Passport();
            userFromDb.setPassport(passport);
            passportService.savePassport(passport);
        }

        return "passport/profile";
    }

    @PostMapping("")
    public String updatePassport(@AuthenticationPrincipal User user,
                                 @RequestParam String firstName,
                                 @RequestParam String surname,
                                 @RequestParam String address,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
                                 @RequestParam String birthPlace,
                                 @RequestParam String codeOfIssuingState,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfIssue,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfExpiry,
                                 @RequestParam String nationality,
                                 @RequestParam String personalNo,
                                 @RequestParam String passportNumber,
                                 @RequestParam Sex sex
    ) {
        User userFromDb = userService.loadUserById(user.getId());
        Passport passport = userFromDb.getPassport();
        passportService.updatePassport(passport, personalNo, firstName, surname, birthDate, birthPlace, address, dateOfIssue,
                dateOfExpiry, codeOfIssuingState, nationality, passportNumber, sex);

        return "redirect:/user/profile";
    }

    @GetMapping("/add")
    public String addPassport() {
        return "passport/passport";
    }

    @PostMapping("/add")
    public String addPassportToRepository(Passport passport, Model model) {
        if (!passportService.addPassport(passport)) {
            model.addAttribute("message", "Passport exists");
            return "redirect:/user/passport";
        }
        return "redirect:/user/passport";
    }

}
