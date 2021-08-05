package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.Doctor;
import by.it_academy.polyclinic.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    List<Treatment> findByDoctor(Doctor doctor);
}
