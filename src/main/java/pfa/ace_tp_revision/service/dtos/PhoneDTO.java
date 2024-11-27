package pfa.ace_tp_revision.service.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneDTO {
    @Id

    private String model;
    private String color;
    private String IMEI;
    private float price;

}
