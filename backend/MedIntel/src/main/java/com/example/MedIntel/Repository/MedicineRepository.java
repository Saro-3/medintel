package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Medicine findByGenericNameIgnoreCase(String genericName);
}
