package v1.archivarapirestserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v1.archivarapirestserver.dao.PatientDao;
import v1.archivarapirestserver.model.Patient;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientDao patientDao;

    public int insertPatient(Patient patient){
        return patientDao.insertPatient(patient);
    }

    public Optional<Patient> lookUpPatient(String snils_id, String surname){
        return patientDao.lookUpPatient(snils_id, surname);
    }
}
