package by.it_academy.polyclinic.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "MedicalCard")
@Table(name = "medical_cards")
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn (name="diseases_id")
    private String diseaseId;

    private Date sickDate;

    private Date recoverDate;

    private String healthStatus;

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Date getSickDate() {
        return sickDate;
    }

    public void setSickDate(Date sickDate) {
        this.sickDate = sickDate;
    }

    public Date getRecoverDate() {
        return recoverDate;
    }

    public void setRecoverDate(Date recoverDate) {
        this.recoverDate = recoverDate;
    }

    public MedicalCard() {
    }
}
