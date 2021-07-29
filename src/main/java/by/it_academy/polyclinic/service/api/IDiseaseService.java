package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.Disease;
import by.it_academy.polyclinic.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IDiseaseService {
    boolean addDisease(Disease disease);
}
