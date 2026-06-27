package com.example.MedIntel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MedicineIndicationDTO {
    private Long id;
    private String indication;

    public MedicineIndicationDTO() {

    }
}
