package com.example.MedIntel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MedicineSafetyDTO {

    private Long id;
    private String pregnancyCategory;
    private String lactationSafety;

    public MedicineSafetyDTO() {

    }
}
