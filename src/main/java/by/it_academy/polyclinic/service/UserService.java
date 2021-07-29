package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.repositories.MediaclCardRepository;
import by.it_academy.polyclinic.repositories.PassportRepository;
import by.it_academy.polyclinic.repositories.UserRepository;
import by.it_academy.polyclinic.service.api.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

import static by.it_academy.polyclinic.model.enumeration.Role.GUEST;

@Service
public class UserService implements UserDetailsService, IUserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private PassportRepository passportRepository;
    private MediaclCardRepository mediaclCardRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, PassportRepository passportRepository, MediaclCardRepository mediaclCardRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.passportRepository = passportRepository;
        this.mediaclCardRepository = mediaclCardRepository;
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
        user.setPassword(password);


//        user.setPassword(passwordEncoder.encode(user.getPassword()));
// TODO ШИФРОВАНИЕ. Раскомментить для шифрования пароля при добавлении пользователя
// Для зашифровки уже сохранённых паролей выполнить в базе данных команды:
// create extension if not exists pgcrypto;
// update users set password = crypt(password, gen_salt('bf',8));

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
    public void updateProfile(User user, String username, String password, String email, String phoneNumber) {
        if (!StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }
        if (!StringUtils.isEmpty(email)) {
            user.setEmail(email);
        }
        if (!StringUtils.isEmpty(phoneNumber)) {
            user.setPhoneNumber(phoneNumber);
        }

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
}
