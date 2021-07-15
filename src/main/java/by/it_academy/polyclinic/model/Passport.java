package by.it_academy.polyclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Passport")
@Table(name = "passports", schema = "polyclinic")
public class Passport {

    @Id
    @Column(name = "id_number")
    private String idNumber; //идентификационный номер пасспорта

    @Column(name = "code_of_issuing_state")
    private String codeOfIssuingState; //орган выдавший пасспорт

    @Column(name = "passport_number")
    private String passportNumber; // номер пасспорта

    @Column(name = "nationality")
    private String nationality; // национальность

    @Column(name = "birth_date")
    private String birthDate; // дата рождения

    @Column(name = "birth_place")
    private String birthPlace; // место рождения

    @Column(name = "sex")
    private String sex; // пол

    @Column(name = "date_of_issue")
    private String dateOfIssue; // дата выдачи пасспорта

    @Column(name = "date_of_expiry")
    private String dateOfExpiry; //окончание срока действия пасспорта

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCodeOfIssuingState() {
        return codeOfIssuingState;
    }

    public void setCodeOfIssuingState(String codeOfIssuingState) {
        this.codeOfIssuingState = codeOfIssuingState;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }


}
