package by.it_academy.polyclinic.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "treatments")
public class Treatment implements Serializable {

    private static final long serialVersionUID = 5664705725854827389L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_cards_id")
    private MedicalCard medicalCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disease_id", foreignKey = @ForeignKey(name = "FK_treatment_disease_id"))
    private Disease disease;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDate sickDate;

    private LocalDate recoverDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicalCard getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(MedicalCard medicalCard) {
        this.medicalCard = medicalCard;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public LocalDate getSickDate() {
        return sickDate;
    }

    public void setSickDate(LocalDate sickDate) {
        this.sickDate = sickDate;
    }

    public LocalDate getRecoverDate() {
        return recoverDate;
    }

    public void setRecoverDate(LocalDate recoverDate) {
        this.recoverDate = recoverDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Treatment() {
    }

    public boolean isPatientSickNow(Treatment treatment) {
        return (treatment.getRecoverDate() == null);
    }
    public boolean isTreatmentHasDisease(Treatment treatment) {
        return (treatment.getDisease() != null);
    }
    public boolean isTreatmentHasDoctor(Treatment treatment) {
        return (treatment.getDoctor() != null);
    }

}
