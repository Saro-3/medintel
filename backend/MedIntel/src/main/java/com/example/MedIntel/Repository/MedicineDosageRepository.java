package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineDosage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicineDosageRepository extends JpaRepository<MedicineDosage, Long> {
    MedicineDosage findByMedicine(Medicine medicine);
}
