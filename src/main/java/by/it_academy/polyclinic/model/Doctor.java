package by.it_academy.polyclinic.model;

import by.it_academy.polyclinic.model.enumeration.Department;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "doctor")
    private User user;

    @Column(name = "department", nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

    private String position;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "medicalCard", cascade = CascadeType.ALL)
    private List<Treatment> treatments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String description) {
        this.position = description;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }
}
