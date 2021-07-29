package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Role;
import by.it_academy.polyclinic.service.PassportService;
import by.it_academy.polyclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private PassportService passportService;

    @Autowired
    public AdminController(UserService userService, PassportService passportService) {
        this.userService = userService;
        this.passportService = passportService;
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
        model.addAttribute("password", userFromDb.getPassword());
        model.addAttribute("passport", userFromDb.getPassport());
        model.addAttribute("role",userFromDb.getRole());
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
        model.addAttribute("passport", passport);
        model.addAttribute("personal_no", passport.getId());
        model.addAttribute("firstName", passport.getFirstName());
        model.addAttribute("surname", passport.getSurname());
        return "passport/passportEdit";
    }

    @PostMapping("passports")
    public String passportSave(@RequestParam Passport passport) {
//        passportService.updatePassport(passport);
        return "redirect:/admin/passports";
    }

}
