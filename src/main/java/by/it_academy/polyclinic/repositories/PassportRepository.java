package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
    Passport findPassportBySurname(String surname);
}
