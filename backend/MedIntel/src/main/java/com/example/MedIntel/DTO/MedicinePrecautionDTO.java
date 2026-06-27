package com.example.MedIntel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class MedicinePrecautionDTO {
    private Long id;
    private String precaution;

    public MedicinePrecautionDTO() {}
}
