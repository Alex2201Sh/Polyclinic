package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Sex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface IPassportService {

    boolean addPassport(Passport passport);

    List<Passport> findAll();

    void updatePassport(Passport passport, String personalNo, String firstName, String surname,
                        LocalDate birthDate, String birthPlace, String address,
                        LocalDate dateOfIssue, LocalDate dateOfExpiry, String codeOFIssuingState,
                        String nationality, String passportNumber, Sex sex);

    Optional<Passport> loadPassportById(Long id);

    void savePassport(Passport passport);

    Passport addPassport(Passport passport, User user);

    Passport loadPassportBySurname(String surname);

    Page<Passport> findAll(Pageable pageable);
}
