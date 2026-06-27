package com.example.MedIntel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MedicineInteractionDTO {

    private Long id;
    private String interaction;

    public MedicineInteractionDTO() {

    }
}
