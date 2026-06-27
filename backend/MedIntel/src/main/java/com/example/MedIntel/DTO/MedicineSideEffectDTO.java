package com.example.MedIntel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class MedicineSideEffectDTO {

    private Long id;
    private String sideEffect;

    public MedicineSideEffectDTO() {

    }
}
