package by.it_academy.polyclinic.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Talon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDate talonDate;
    private String talonTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getTalonDate() {
        return talonDate;
    }

    public void setTalonDate(LocalDate talonDate) {
        this.talonDate = talonDate;
    }

    public String getTalonTime() {
        return talonTime;
    }

    public void setTalonTime(String talonTime) {
        this.talonTime = talonTime;
    }
}
