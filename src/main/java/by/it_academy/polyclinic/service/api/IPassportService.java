package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface IPassportService {

    boolean addPassport(Passport passport);

    List<Passport> findAll();

    Optional<Passport> loadPassportById(Long id);

    void savePassport(Passport passport);

    Passport addPassport(Passport passport, User user);

    void updatePassport(Passport passport, String passportId, String firstName, String surname, LocalDate birthDate,
                        String birthPlace, String address,
                        LocalDate dateOfIssue, LocalDate dateOfExpiry, String codeOFIssuingState,
                        String nationality, String sex, String passportNumber);

    void delete(Long id);

}
