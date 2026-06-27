package com.example.MedIntel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MedicineDosageDTO {

    private Long id;
    private String adultDose;
    private String childDose;
    private String maxDose;

    public MedicineDosageDTO() {

    }
}
