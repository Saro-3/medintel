package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineInteraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineInteractionRepository extends JpaRepository<MedicineInteraction, Long> {
    List<MedicineInteraction> findByMedicine(Medicine medicine);
}
