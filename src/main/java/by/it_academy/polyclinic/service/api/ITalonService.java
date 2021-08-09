package by.it_academy.polyclinic.service.api;

import by.it_academy.polyclinic.model.Talon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ITalonService {
    List<Talon> findAll();
    boolean addTalon(Talon talon);
    Optional<Talon> loadTalonById(Long id);
    Page<Talon> findAll(Pageable pageable);
    void deleteTalon(Long id);
}
