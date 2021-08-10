package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.MedicalCard;
import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.repositories.MedicalCardRepository;
import by.it_academy.polyclinic.repositories.UserRepository;
import by.it_academy.polyclinic.service.api.IMedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalCardService implements IMedicalCardService {

    private MedicalCardRepository medicalCardRepository;
    private UserService userService;
    private UserRepository userRepository;
    private DiseaseService diseaseService;

    @Autowired
    public MedicalCardService(MedicalCardRepository medicalCardRepository, UserService userService, UserRepository userRepository, DiseaseService diseaseService) {
        this.medicalCardRepository = medicalCardRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.diseaseService = diseaseService;
    }

    @Override
    public boolean addMedicalCard(MedicalCard medicalCard) {
        Optional<MedicalCard> medicalCardFromDb = medicalCardRepository.findById(medicalCard.getId());
        if (medicalCardFromDb != null) {
            return false;
        }
        medicalCardRepository.save(medicalCard);
        return true;
    }

    @Override
    public List<MedicalCard> findAll() {
        return medicalCardRepository.findAll();
    }

    public void saveMedicalCard(MedicalCard medicalCard) {
        medicalCardRepository.save(medicalCard);
    }

    @Override
    public MedicalCard addMedicalCard(MedicalCard medicalCard, User user) {
        User userFromDb = userRepository.findById(user.getId()).get();

        userFromDb.setMedicalCard(medicalCard);
        medicalCardRepository.save(medicalCard);
        userRepository.save(user);

        return medicalCard;
    }

    @Override
    public Optional<MedicalCard> loadMedicalCardById(Long id) {
        return medicalCardRepository.findById(id);
    }
}
