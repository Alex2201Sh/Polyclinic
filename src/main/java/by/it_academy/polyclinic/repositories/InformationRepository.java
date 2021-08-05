package by.it_academy.polyclinic.repositories;

import by.it_academy.polyclinic.model.Information;
import by.it_academy.polyclinic.model.enumeration.InfoType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InformationRepository extends CrudRepository<Information,Long> {
    List<Information> findByTag(String tag);
    List<Information> findByInfoType(InfoType infotype);
}
