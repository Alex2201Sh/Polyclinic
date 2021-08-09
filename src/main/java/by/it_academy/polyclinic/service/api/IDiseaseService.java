package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.Disease;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IDiseaseService {
    List<Disease> findAll();
    boolean addDisease(Disease disease);
    Disease loadDiseaseById(Long id);
    Page<Disease> findAll(Pageable pageable);

}
