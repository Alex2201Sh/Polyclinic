package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;

@Service
public interface IUserService extends UserDetailsService {

    UserDetails loadUserByUsername(String username);

    boolean addUser(String username, String password, String email, String phone);

    List<User> findAll();

    void updateProfile(User user);

    void deleteUser(Long id);

    Passport createPassport(User user, Passport passport);

    Passport updatePassport(User user, Passport passport);

    void deletePassport(User user);

    User loadUserByPassportId(Long id);

    List<User> findUsersByRole(Role role);

    Page<User> findAll(Pageable pageable);


}
