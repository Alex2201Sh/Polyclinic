package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
        User userFromDb = (User) userService.loadUserByUsername(user.getUsername());
        model.addAttribute("username", userFromDb.getUsername());
        model.addAttribute("email", userFromDb.getEmail());
        model.addAttribute("phoneNumber", userFromDb.getPhoneNumber());
        model.addAttribute("passport", userFromDb.getPassport());
        model.addAttribute("user",userFromDb);
        return "user/profile";
    }

    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @RequestParam String password,
                                @RequestParam String email,
                                @RequestParam String phoneNumber) {
        User userFromDb = userService.loadUserById(user.getId());
        if (!StringUtils.isEmpty(password)) {
            userFromDb.setPassword(passwordEncoder.encode(password));
        }
        if (!StringUtils.isEmpty(email)) {
            userFromDb.setEmail(email);
        }
        if (!StringUtils.isEmpty(phoneNumber)) {
            userFromDb.setPhoneNumber(phoneNumber);
        }

        userService.updateProfile(userFromDb);
        return "redirect:/user/profile";
    }
}
