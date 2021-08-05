package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.Disease;
import by.it_academy.polyclinic.model.MedicalCard;
import by.it_academy.polyclinic.repositories.DiseaseRepository;
import by.it_academy.polyclinic.service.api.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiseaseService implements IDiseaseService {

    private DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public boolean addDisease(Disease disease) {
        Disease diseaseFromDb = diseaseRepository.findByName(disease.getName());
        if (diseaseFromDb != null) {
            return false;
        }
        diseaseRepository.save(disease);
        return true;
    }

    @Override
    public List<Disease> findAll() {
        return diseaseRepository.findAll();
    }

    public void updateDisease(Disease disease) {
        Disease diseaseFromdb = diseaseRepository.findById(disease.getId()).get();
        diseaseFromdb.setName(disease.getName());
        diseaseFromdb.setDescription(disease.getDescription());
    }

    @Override
    public Optional<Disease> loadDiseaseById(Long id) {
        return diseaseRepository.findById(id);
    }

    public Disease findDiseaseByName(String name) {
        return diseaseRepository.findByName(name);
    }
}
