package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.*;
import by.it_academy.polyclinic.repositories.MedicalCardRepository;
import by.it_academy.polyclinic.repositories.PassportRepository;
import by.it_academy.polyclinic.repositories.TreatmentRepository;
import by.it_academy.polyclinic.repositories.UserRepository;
import by.it_academy.polyclinic.service.api.ITreatmentService;
import by.it_academy.polyclinic.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static by.it_academy.polyclinic.model.enumeration.Role.GUEST;

@Service
public class TreatmentService implements ITreatmentService {

    private UserRepository userRepository;
    private MedicalCardRepository medicalCardRepository;
    private DiseaseService diseaseService;
    private TreatmentRepository treatmentRepository;
    private DoctorService doctorService;

    @Autowired
    public TreatmentService(UserRepository userRepository, MedicalCardRepository medicalCardRepository, DiseaseService diseaseService, TreatmentRepository treatmentRepository, DoctorService doctorService) {
        this.userRepository = userRepository;
        this.medicalCardRepository = medicalCardRepository;
        this.diseaseService = diseaseService;
        this.treatmentRepository = treatmentRepository;
        this.doctorService = doctorService;
    }

    @Override
    public void addTreatment(Treatment treatment) {
        treatmentRepository.save(treatment);
    }

    @Override
    public void updateTreatment(Treatment treatment, Disease disease, LocalDate recoverDate) {
        treatment.setDisease(disease);
        treatment.setRecoverDate(recoverDate);
        treatmentRepository.save(treatment);
    }

    @Override
    public List<Treatment> findAll(User user) {
        MedicalCard medicalCard = user.getMedicalCard();
        List<Treatment> treatments = medicalCard.getTreatments();
        return treatments;
    }

    public String findDoctorSurnameByDoctorId(Long doctorId){
        return doctorService.loadDoctorById(doctorId).get().getUser().getPassport().getSurname();
    }

    @Override
    public List<Treatment> findByDoctor(Doctor doctor) {
        return treatmentRepository.findByDoctor(doctor);
    }

    public List<Treatment> findWithoutDoctor() {
        return treatmentRepository.findByDoctor(null);
    }
}
