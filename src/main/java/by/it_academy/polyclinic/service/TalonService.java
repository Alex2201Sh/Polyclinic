package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.Talon;
import by.it_academy.polyclinic.repositories.TalonRepository;
import by.it_academy.polyclinic.service.api.ITalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalonService implements ITalonService {

    private TalonRepository talonRepository;

    @Autowired
    public TalonService(TalonRepository talonRepository) {
        this.talonRepository = talonRepository;
    }

    @Override
    public boolean addTalon(Talon talon) {
        talonRepository.save(talon);
        return true;
    }

    @Override
    public List<Talon> findAll() {
        return talonRepository.findAll();
    }

    public void updateTalon(Talon talon) {
        Talon talonFromdb = talonRepository.findById(talon.getId()).get();
        talonFromdb.setDoctor(talon.getDoctor());
        talonFromdb.setTalonDate(talon.getTalonDate());
        talonFromdb.setTalonTime(talon.getTalonTime());
    }

    @Override
    public Optional<Talon> loadTalonById(Long id) {
        return talonRepository.findById(id);
    }

    @Override
    public void deleteTalon(Long id) {
        talonRepository.deleteById(id);
    }

    public void deleteTalon(Talon talon) {
        talonRepository.delete(talon);
    }

    @Override
    public Page<Talon> findAll(Pageable pageable) {
        return talonRepository.findAll(pageable);
    }
}
