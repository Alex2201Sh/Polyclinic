package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Role;
import by.it_academy.polyclinic.repositories.MedicalCardRepository;
import by.it_academy.polyclinic.repositories.PassportRepository;
import by.it_academy.polyclinic.repositories.UserRepository;
import by.it_academy.polyclinic.service.api.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.*;

import static by.it_academy.polyclinic.model.enumeration.Role.GUEST;

@Service
@Validated
public class UserService implements UserDetailsService, IUserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private PassportRepository passportRepository;
    private MedicalCardRepository medicalCardRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, PassportRepository passportRepository, MedicalCardRepository medicalCardRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.passportRepository = passportRepository;
        this.medicalCardRepository = medicalCardRepository;
    }

    public boolean addUser(String username, String password, String email, String phone) {
        User userFromDb = userRepository.findByUsername(username);
        if (userFromDb != null) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        if (!StringUtils.isEmpty(email)) {
            user.setEmail(email);
        }
        if (!StringUtils.isEmpty(phone)) {
            user.setPhoneNumber(phone);
        }
        user.setRole(GUEST);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        return true;
    }

    public User loadUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id" + id + "was not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void updateProfile(@Valid User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public Passport createPassport(User user, Passport passport) {
        return null;
    }

    @Override
    public Passport updatePassport(User user, Passport passport) {
        return null;
    }

    @Override
    public void deletePassport(User user) {
    }

    @Override
    public User loadUserByPassportId(Long id) {
        return userRepository.findByPassportId(id);
    }

    @Override
    public List<User> findUsersByRole(Role role) {
        return userRepository.findUsersByRole(role);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
