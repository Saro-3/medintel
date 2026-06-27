package com.example.MedIntel.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicine_storage")
public class MedicineStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;      // Parent Class

    @Column(name = "storage_instructions")
    private String storageInstructions;

    @Column(name = "expiry_period")
    private String expiryPeriod;

    @Column(name = "batch_number")
    private String batchNumber;
}
