package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.Disease;
import by.it_academy.polyclinic.repositories.DiseaseRepository;
import by.it_academy.polyclinic.service.api.IDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class DiseaseService implements IDiseaseService {

    private DiseaseRepository diseaseRepository;

    @Autowired
    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public boolean addDisease(Disease disease) {
        Disease diseaseFromDb = diseaseRepository.findDiseaseByName(disease.getName());
        if (diseaseFromDb != null) {
            return false;
        }
        diseaseRepository.save(disease);
        return true;
    }
}
