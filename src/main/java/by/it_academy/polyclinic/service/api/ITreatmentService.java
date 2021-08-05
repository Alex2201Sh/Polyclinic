package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ITreatmentService  {
    void addTreatment(Treatment treatment);
    void updateTreatment(Treatment treatment, Disease disease, LocalDate recoverDate);
    List<Treatment> findAll(User user);
    List<Treatment> findByDoctor(Doctor doctor);
}


