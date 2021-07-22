package by.it_academy.polyclinic.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;

@Entity(name = "Passport")
@Table(name = "passports")
public class Passport {

    @Id
    @NotNull
    private String id; //идентификационный номер пасспорта

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name 2..30 chars")
    private String firstName;

    private String surname;

    private String address;

    private String codeOfIssuingState; //орган выдавший пасспорт

    private String passportNumber; // номер пасспорта

    private String nationality; // национальность

    private String birthDate; // дата рождения

    private String birthPlace; // место рождения

    private String sex; // пол

    private String dateOfIssue; // дата выдачи пасспорта

    private String dateOfExpiry; //окончание срока действия пасспорта

    public String getId() {
        return id;
    }

    public void setIdNumber(String id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Passport() {
    }
}
