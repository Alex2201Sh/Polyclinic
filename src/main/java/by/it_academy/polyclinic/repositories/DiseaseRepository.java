package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    Optional<Disease> findById(Long id);
    Disease findDiseaseByName(String name);

}
