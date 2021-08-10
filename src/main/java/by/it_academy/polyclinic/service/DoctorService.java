package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.Doctor;
import by.it_academy.polyclinic.model.Passport;
import by.it_academy.polyclinic.repositories.DoctorRepository;
import by.it_academy.polyclinic.service.api.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {

    private DoctorRepository doctorRepository;
    private UserService userService;
    private PassportService passportService;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, UserService userService, PassportService passportService) {
        this.doctorRepository = doctorRepository;
        this.userService = userService;
        this.passportService = passportService;
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        if (doctor.getId() != null) {
            return false;
        }
        doctorRepository.save(doctor);
        return true;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public void updateDoctor(Doctor doctor) {
        Doctor doctorFromdb = doctorRepository.findById(doctor.getId()).get();
        doctorFromdb.setDepartment(doctor.getDepartment());
        doctorFromdb.setPosition(doctor.getPosition());
        doctorRepository.save(doctorFromdb);
    }

    @Override
    public Optional<Doctor> loadDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor loadDoctorBySurname(String doctorSurname) {
        if (!StringUtils.isEmpty(doctorSurname)) {
            Passport doctorPassport = passportService.loadPassportBySurname(doctorSurname);
            return doctorPassport.getUser().getDoctor();
        } else return null;
    }
}
