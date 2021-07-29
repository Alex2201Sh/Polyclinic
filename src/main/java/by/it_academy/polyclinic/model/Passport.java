package by.it_academy.polyclinic.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "passports")
public class Passport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(String personalNo) {
        this.personalNo = personalNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "personal_no", nullable = true, unique = true)
    private String personalNo;

    @OneToOne(mappedBy = "passport")
    private User user;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name 2..30 chars")
    private String firstName;

    private String surname;

    private String address;

    private String codeOfIssuingState; //орган выдавший пасспорт

    private String passportNumber; // номер пасспорта

    private String nationality; // национальность

    private LocalDate birthDate; // дата рождения

    private String birthPlace; // место рождения

    private String sex; // пол

    private LocalDate dateOfIssue; // дата выдачи пасспорта

    private LocalDate dateOfExpiry; //окончание срока действия пасспорта

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
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

    public boolean isPassportHasOwner(Passport passport) {
        return passport.getUser() != null;
    }
}
