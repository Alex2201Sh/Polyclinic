package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
