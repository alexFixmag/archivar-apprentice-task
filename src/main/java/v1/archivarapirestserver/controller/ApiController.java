package v1.archivarapirestserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import v1.archivarapirestserver.model.MedicalOrg;
import v1.archivarapirestserver.model.Patient;
import v1.archivarapirestserver.service.MedicalOrgService;
import v1.archivarapirestserver.service.PatientService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MedicalOrgService medicalOrgService;
    @Autowired
    private PatientService patientService;

    /*HTTP GET on request*/
    @RequestMapping(value = "/mo",method = RequestMethod.GET)
    public Collection<MedicalOrg> getAllMedicalOrgs(){
        return medicalOrgService.getAllMedicalOrgs();
    }

    /*HTTP POST on request*/
    @RequestMapping(value = "/data", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertPatient(@RequestBody Patient patient){
        int operationCode = patientService.insertPatient(patient);
        if(operationCode == -1){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Patient with such userId already exists");
        }
    }

    /*HTTP GET on request (specific Patient)*/
    @RequestMapping(value = "/iemk/{snils_id}/{surname}", method = RequestMethod.GET)
    public Optional<Patient> lookUpPatient(@PathVariable("snils_id") String snils_id, @PathVariable("surname") String surname){
        return patientService.lookUpPatient(snils_id, surname);
    }
    @RequestMapping(value = "/iemk/snils/{snilsId}", method = RequestMethod.GET)
    public Optional<Patient> lookUpPatientBySnilsId(@PathVariable("snilsId") String snilsId){
        return patientService.lookUpPatient(snilsId, null);
    }
    @RequestMapping(value = "/iemk/surname/{surname}", method = RequestMethod.GET)
    public Optional<Patient> lookUpPatientBySurname(@PathVariable("surname") String surname){
        return patientService.lookUpPatient(null, surname);
    }
}
