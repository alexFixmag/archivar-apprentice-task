package v1.archivarapirestserver.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import v1.archivarapirestserver.model.Patient;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PatientDao {

    /*for making SQL queries*/
    JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertPatient(Patient patient){
        /*Check if patient with such user_id already exists*/
        String queryCheck = "SELECT EXISTS (SELECT user_id FROM archivist.patients WHERE user_id = ?)";
        boolean exist = jdbcTemplate.queryForObject(queryCheck, new Object[] {patient.getUserId()}, Boolean.class);
        /*Note: Inserts new Patient in DB, where
         USER ID is vital for being, other Attributes might be null*/
        if(!exist) {
            String query = "INSERT INTO archivist.patients (user_id, name, surname, patronymic, " +
                    "date_of_birth, snils_id, polys_oms_id, patient_card_id, date_insert, date_update)" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?)";

            jdbcTemplate.update(query, patient.getUserId(), patient.getName(),
                    patient.getSurname(), patient.getPatronymic(), LocalDate.parse(patient.getDateOfBirth()),
                    patient.getSnilsId(), patient.getPolysOMSId(), patient.getPatientCardId(),
                    LocalDateTime.now(), LocalDateTime.now());

            //operation success
            return 1;
        }
        else{
            //operation failed
            return -1;
        }
    }

    public Optional<Patient> lookUpPatient(String snilsId_, String surname_){
        /*Note: looks up Patient in DB by snils_Id or/and his/her surname*/
        String query  = "SELECT * FROM archivist.patients WHERE snils_id = '" + snilsId_ + "'" +
                " OR surname = '" + surname_+ "'";

        Patient patient = jdbcTemplate.queryForObject(query,(resultSet, i) -> {
            String user_id = resultSet.getString("user_id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String patronymic = resultSet.getString("patronymic");
            String date_of_birth = resultSet.getString("date_of_birth");
            String snils_id = resultSet.getString("snils_id");
            String polys_oms_id = resultSet.getString("polys_oms_id");
            String patient_card_id = resultSet.getString("patient_card_id");
            LocalDateTime date_insert = Timestamp.valueOf(resultSet.getString("date_insert")).toLocalDateTime();
            LocalDateTime date_update = Timestamp.valueOf(resultSet.getString("date_update")).toLocalDateTime();

            Patient patient_ = new Patient(user_id, name, surname, patronymic, date_of_birth,
                    snils_id, polys_oms_id, patient_card_id);
            patient_.setDate_insert(date_insert);
            patient_.setDate_update(date_update);
            return patient_;
        });
        return Optional.ofNullable(patient);
    }
}
