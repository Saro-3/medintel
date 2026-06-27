package com.example.MedIntel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MedicineStorageDTO {

    private Long id;
    private String storageInstruction;
    private String expiryPeriod;
    private String batchNumber;

    public MedicineStorageDTO() {

    }
}
