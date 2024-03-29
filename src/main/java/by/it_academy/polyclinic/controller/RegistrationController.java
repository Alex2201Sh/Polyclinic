package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.service.PassportService;
import by.it_academy.polyclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String addUserToRepository(User user, Model model) {

        if (!userService.addUser(user.getUsername(),user.getPassword(),user.getEmail(),user.getPhoneNumber())) {
            model.addAttribute("message", "Пользователь с таким логином сущетвует");
            return "/registration";
        }
        return "redirect:/login";
    }
}
