package com.example.MedIntel.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MedicineBrandDTO {

    private Long id;
    private String brandName;
    private String manufacturer;
    private String price;

    public MedicineBrandDTO() {

    }
}
