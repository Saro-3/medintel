package com.example.MedIntel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class MedicineContraindicationDTO {

    private Long id;
    private String contraindication;

    public MedicineContraindicationDTO() {}
}
