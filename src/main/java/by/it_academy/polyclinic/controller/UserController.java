package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
        model.addAttribute("username", userFromDb.getUsername());
        model.addAttribute("email", userFromDb.getEmail());
        model.addAttribute("phoneNumber", userFromDb.getPhoneNumber());
        model.addAttribute("passport", userFromDb.getPassport());
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String password,
                                @RequestParam String email,
                                @RequestParam String phoneNumber) {
        userService.updateProfile(user, user.getUsername(), password, email, phoneNumber);
        return "redirect:/user/profile";
    }

//    @GetMapping("medcard")
//    public String getTreatments(Model model, @AuthenticationPrincipal User user) {
//        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
//        if (userFromDb.isUserHasMedicalCard(userFromDb)) {
//            model.addAttribute("medicalCard",userFromDb.getMedicalCard());
//            model.addAttribute("treatments", userFromDb.getMedicalCard().getTreatments());
//            return "medcard";
//        } else return "redirect:/user/profile";
//    }

//    @PostMapping("profile")
//    public String updateProfile(@AuthenticationPrincipal User user,
//                                @RequestParam String password,
//                                @RequestParam String email,
//                                @RequestParam String phoneNumber) {
//        userService.updateProfile(user, user.getUsername(), password, email, phoneNumber);
//        return "redirect:/user/profile";
//    }


}
