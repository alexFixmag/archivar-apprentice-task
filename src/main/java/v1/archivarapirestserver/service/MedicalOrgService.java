package v1.archivarapirestserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v1.archivarapirestserver.dao.MedicalOrgDao;
import v1.archivarapirestserver.model.MedicalOrg;

import java.util.Collection;
import java.util.List;

@Service
public class MedicalOrgService {

    @Autowired
    private MedicalOrgDao medicalOrgDao;

    public Collection<MedicalOrg> getAllMedicalOrgs(){
        return medicalOrgDao.getAllMedicalOrgs();
    }
}
