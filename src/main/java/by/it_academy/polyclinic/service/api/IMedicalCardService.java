package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.MedicalCard;
import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface IMedicalCardService {

    boolean addMedicalCard(MedicalCard medicalCard);

    List<MedicalCard> findAll();

    Optional<MedicalCard> loadMedicalCardById(Long id);

    void saveMedicalCard(MedicalCard medicalCard);

    MedicalCard addMedicalCard(MedicalCard medicalCard, User user);

//    void updateMedicalCard(MedicalCard medicalCard, String diseaseId, LocalDate sickDate, LocalDate recoverDate, Integer healthStatus);
}
