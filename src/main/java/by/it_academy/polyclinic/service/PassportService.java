package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Sex;
import by.it_academy.polyclinic.repositories.PassportRepository;
import by.it_academy.polyclinic.repositories.UserRepository;
import by.it_academy.polyclinic.service.api.IPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PassportService implements IPassportService {

    private PassportRepository passportRepository;
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public PassportService(PassportRepository passportRepository, UserService userService, UserRepository userRepository) {
        this.passportRepository = passportRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public boolean addPassport(Passport passport) {
        Optional<Passport> passportFromDb = passportRepository.findById(passport.getId());

        if (passportFromDb != null) {
            return false;
        }
        passportRepository.save(passport);

        return true;
    }

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    public void savePassport(Passport passport) {
        passportRepository.save(passport);
    }

    @Override
    public Passport addPassport(Passport passport, User user) {

        User repositoryUser = userRepository.findById(user.getId()).get();

        repositoryUser.setPassport(passport);
        passportRepository.save(passport);
        userRepository.save(user);

        return passport;
    }

    @Override
    public void updatePassport(Passport passport, String personalNo, String firstName, String surname,
                               LocalDate birthDate, String birthPlace, String address,
                               LocalDate dateOfIssue, LocalDate dateOfExpiry, String codeOFIssuingState,
                               String nationality, String passportNumber, Sex sex) {
        if (!StringUtils.isEmpty(personalNo)) {
            passport.setPersonalNo(personalNo);
        }
        if (!StringUtils.isEmpty(firstName)) {
            passport.setFirstName(firstName);
        }
        if (!StringUtils.isEmpty(surname)) {
            passport.setSurname(surname);
        }
        if (!StringUtils.isEmpty(birthDate)) {
            passport.setBirthDate(birthDate);
        }
        if (!StringUtils.isEmpty(birthPlace)) {
            passport.setBirthPlace(birthPlace);
        }
        if (!StringUtils.isEmpty(address)) {
            passport.setAddress(address);
        }
        if (!StringUtils.isEmpty(dateOfIssue)) {
            passport.setDateOfIssue(dateOfIssue);
        }
        if (!StringUtils.isEmpty(dateOfExpiry)) {
            passport.setDateOfExpiry(dateOfExpiry);
        }
        if (!StringUtils.isEmpty(codeOFIssuingState)) {
            passport.setCodeOfIssuingState(codeOFIssuingState);
        }
        if (!StringUtils.isEmpty(nationality)) {
            passport.setNationality(nationality);
        }
        if (!StringUtils.isEmpty(passportNumber)) {
            passport.setPassportNumber(passportNumber);
        }
        if (!StringUtils.isEmpty(sex)) {
            passport.setSex(sex);
        }
        passportRepository.save(passport);
    }

    public void updatePassport(Passport passport) {
        passportRepository.save(passport);
    }

    @Override
    public Optional<Passport> loadPassportById(Long id) {
        return passportRepository.findById(id);
    }

    @Override
    public Passport loadPassportBySurname(String surname) {
        return passportRepository.findPassportBySurname(surname);
    }
}
