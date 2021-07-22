package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.Role;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }
        user.setRoles(Collections.singleton(Role.GUEST));
        userRepository.save(user);

        return true;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);

    }

    public void updateProfile(User user, String password, String email, String phoneNumber) {


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

    public void delete(Long id) {
        userRepository.findById(id);
    }
}
