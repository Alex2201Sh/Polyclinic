package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.repositories.MediaclCardRepository;
import by.it_academy.polyclinic.service.api.IMedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;

public class MedicalCardService implements IMedicalCardService {

    private MediaclCardRepository mediaclCardRepository;

    @Autowired
    public MedicalCardService(MediaclCardRepository mediaclCardRepository) {
        this.mediaclCardRepository = mediaclCardRepository;
    }

    @Override
    public void add(String deseaseId, Date sickDate, Date recoverDate, String healthStatus) {
        //TODO
    }
}
