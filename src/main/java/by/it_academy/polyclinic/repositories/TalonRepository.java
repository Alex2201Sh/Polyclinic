package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.Talon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TalonRepository extends JpaRepository<Talon, Long> {
    Optional<Talon> findById(Long id);
    Page<Talon> findAll(Pageable pageable);
    void deleteById(Long id);

}
