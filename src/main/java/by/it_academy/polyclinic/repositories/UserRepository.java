package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.User;
import by.it_academy.polyclinic.model.enumeration.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findById(Long id);
    void deleteById(Long id);
    User findByPassportId(Long id);
    User findByMedicalCardId(Long id);
    List <User> findUsersByRole(Role role);
    Page<User> findAll(Pageable pageable);

}
