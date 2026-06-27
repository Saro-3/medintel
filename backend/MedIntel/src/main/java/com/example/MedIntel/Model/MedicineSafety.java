package com.example.MedIntel.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicine_safety")
public class MedicineSafety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;      // Parent Class

    @Column(name = "pregnancy_category")
    private String pregnancyCategory;

    @Column(name = "lactation_safety")
    private String lactationSafety;
}
