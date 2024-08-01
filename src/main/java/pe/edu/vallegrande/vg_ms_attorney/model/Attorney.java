package pe.edu.vallegrande.vg_ms_attorney.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("attorney")
public class Attorney {
    @Id
    private String id;
    private String names;
    private String surnames;
    private String sex;
    private String birth_date;
    private String baptism;
    private String first_Communion;
    private String confirmation;
    private String marriage;
    private String relationship;
    private String email;
    private String cellphone;
    private String address;
    private String documentType;
    private String documentNumber;
    private String status = "A";
}
