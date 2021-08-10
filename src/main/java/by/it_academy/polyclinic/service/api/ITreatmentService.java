package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.Disease;
import by.it_academy.polyclinic.model.Doctor;
import by.it_academy.polyclinic.model.Treatment;
import by.it_academy.polyclinic.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ITreatmentService  {
    void addTreatment(Treatment treatment);
    void updateTreatment(Treatment treatment, Disease disease, LocalDate recoverDate);
    List<Treatment> findAll(User user);
    List<Treatment> findByDoctor(Doctor doctor);
    Treatment loadTreatmentById(Long id);
}


