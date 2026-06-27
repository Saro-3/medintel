package com.example.MedIntel.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicine_dosage")
public class MedicineDosage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne                           // One TO One
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;         // Parent Class reference

    @Column(name = "adult_dose")
    private String adultDose;

    @Column(name = "child_dose")
    private String childDose;

    @Column(name = "max_dose")
    private String maxDose;
}
