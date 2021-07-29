package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.service.PassportService;
import by.it_academy.polyclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    private UserService userService;
    private PassportService passportService;

    @Autowired
    public RegistrationController(UserService userService, PassportService passportService) {
        this.userService = userService;
        this.passportService = passportService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUserToRepository(User user, Map<String, Object> model) {

        if (!userService.addUser(user.getUsername(),user.getPassword(),user.getEmail(),user.getPhoneNumber())) {
            model.put("message", "User exists");
            return "/registration";
        }
        return "redirect:/login";
    }
}
