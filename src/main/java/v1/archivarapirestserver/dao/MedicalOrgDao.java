package v1.archivarapirestserver.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import v1.archivarapirestserver.model.MedicalOrg;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public class MedicalOrgDao {

    /*for making SQL queries*/
    JdbcTemplate jdbcTemplate;

    @Autowired
    public MedicalOrgDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<MedicalOrg> getAllMedicalOrgs(){
        String query = "SELECT * FROM archivist.ref_mo WHERE is_shown = true " +
                "AND version = (SELECT MAX(version) FROM archivist.ref_mo)";

        List<MedicalOrg> medicalsOrgs = jdbcTemplate.query(query, (resultSet, i)-> {
            String oid = resultSet.getString("oid");
            String version = resultSet.getString("version");
            String nameFull = resultSet.getString("namefull");
            String nameShort = resultSet.getString("nameshort");
            BigDecimal guid = BigDecimal.valueOf(Double.parseDouble(resultSet.getString("guid")));
            /*
             * Comment: for some reason only first letter of attribute
             * is retrieved, so I decided to "convert"
             */
            boolean isShown = resultSet.getString("is_shown").equals("t");
            return new MedicalOrg(oid, version, nameFull, nameShort, guid, isShown);
        });
        return medicalsOrgs;
    }
}
