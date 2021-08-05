package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.service.MedicalCardService;
import by.it_academy.polyclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/medcard")
public class MedicalCardController {

    private MedicalCardService medicalCardService;
    private UserService userService;

    public MedicalCardController(MedicalCardService medicalCardService, UserService userService) {
        this.medicalCardService = medicalCardService;
        this.userService = userService;
    }

//    @GetMapping("")
//    public String getMedicalCard(@AuthenticationPrincipal User user, Model model) {
//        User userFromDb = userService.loadUserById(user.getId());
//        if (userFromDb.isUserHasMedicalCard(userFromDb)) {
//            MedicalCard medicalCard = userFromDb.getMedicalCard();
//            model.addAttribute("medicalCardId",medicalCard.getId());
//
//        } else {
//            MedicalCard medicalCard = new MedicalCard();
//            userFromDb.setMedicalCard(medicalCard);
//            medicalCardService.saveMedicalCard(medicalCard);
//        }
//
//        return "medcard";
//    }

//    @PostMapping("")
//    public String updatePassport(@AuthenticationPrincipal User user,
//                                 @RequestParam String firstName,
//                                 @RequestParam String surname,
//                                 @RequestParam String address,
//                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate,
//                                 @RequestParam String birthPlace,
//                                 @RequestParam String codeOfIssuingState,
//                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfIssue,
//                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfExpiry,
//                                 @RequestParam String nationality,
//                                 @RequestParam String personalNo,
//                                 @RequestParam String passportNumber,
//                                 @RequestParam String sex
//    ) {
//        User userFromDb = userService.loadUserById(user.getId());
//        Passport passport = userFromDb.getPassport();
//        passportService.updatePassport(passport, personalNo, firstName, surname, birthDate, birthPlace, address, dateOfIssue,
//                dateOfExpiry, codeOfIssuingState, nationality, passportNumber, sex);
//
//        return "redirect:/user/profile";
//    }
//
//    @GetMapping("/add")
//    public String addPassport() {
//        return "passport/passport";
//    }
//
//    @PostMapping("/add")
//    public String addPassportToRepository(Passport passport, Model model) {
//        if (!passportService.addPassport(passport)) {
//            model.addAttribute("message", "Passport exists");
//            return "redirect:/user/passport";
//        }
//        return "redirect:/user/passport";
//    }

}
