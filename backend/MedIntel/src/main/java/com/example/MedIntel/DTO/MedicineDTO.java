package com.example.MedIntel.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class MedicineDTO {

    private Long id;
    private String genericName;
    private String strength;
    private String dosageForm;
    private String api;
    private String drugClass;
    private String composition;
    private String schedule;
    private String imageUrl;


    public MedicineDTO() {

    }
}
