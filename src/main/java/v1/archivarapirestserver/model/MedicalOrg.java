package v1.archivarapirestserver.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MedicalOrg {

    String oid;
    String version;
    String nameFull;
    String nameShort;
    BigDecimal guid;
    Boolean isShown;

    public MedicalOrg(String oid, String version, String nameFull, String nameShort, BigDecimal guid, Boolean isShown){
        this.oid = oid;
        this.nameFull = nameFull;
        this.version = version;
        this.nameFull = nameFull;
        this.nameShort = nameShort;
        this.guid = guid;
        this.isShown = isShown;
    }

}
