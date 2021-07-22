package by.it_academy.polyclinic.model;

import javax.persistence.*;

@Entity(name = "Disease")
@Table(name = "diseases")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

}
