package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaclCardRepository extends JpaRepository<MedicalCard, Long> {
    Optional<MedicalCard> findById(Long id);
}
