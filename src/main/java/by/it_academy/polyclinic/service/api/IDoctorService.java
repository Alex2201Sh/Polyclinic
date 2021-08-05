package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IDoctorService {
    List<Doctor> findAll();
    boolean addDoctor(Doctor doctor);
    Optional<Doctor> loadDoctorById(Long id);
    Doctor loadDoctorBySurname(String doctorSurname);

}
