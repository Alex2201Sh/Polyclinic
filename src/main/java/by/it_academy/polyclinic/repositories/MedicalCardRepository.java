package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> {
}
