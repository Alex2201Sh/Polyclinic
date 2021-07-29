package by.it_academy.polyclinic.service.api;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface IMedicalCardService {
    void add (String deseaseId, Date sickDate, Date recoverDate, String healthStatus);
}
