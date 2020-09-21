package v1.archivarapirestserver.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Patient {

    String userId;
    /*Attributes of Patient*/
    String name;
    String surname;
    String patronymic;
    String dateOfBirth;/*Y-M-D*/
    String snilsId;
    String polysOMSId;
    String patientCardId;
    LocalDateTime date_insert;
    LocalDateTime date_update;

    public Patient(String userId, String name, String surname,
                   String patronymic, String dateOfBirth,
                   String snilsId, String polysOMSId, String patientCardId) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.snilsId = snilsId;
        this.polysOMSId = polysOMSId;
        this.patientCardId = patientCardId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSnilsId() {
        return snilsId;
    }

    public void setSnilsId(String snilsId) {
        this.snilsId = snilsId;
    }

    public String getPolysOMSId() {
        return polysOMSId;
    }

    public void setPolysOMSId(String polysOMSId) {
        this.polysOMSId = polysOMSId;
    }

    public String getPatientCardId() {
        return patientCardId;
    }

    public void setPatientCardId(String patientCardId) {
        this.patientCardId = patientCardId;
    }

    public LocalDateTime getDate_insert() {
        return date_insert;
    }

    public void setDate_insert(LocalDateTime date_insert) {
        this.date_insert = date_insert;
    }

    public LocalDateTime getDate_update() {
        return date_update;
    }

    public void setDate_update(LocalDateTime date_update) {
        this.date_update = date_update;
    }
}
