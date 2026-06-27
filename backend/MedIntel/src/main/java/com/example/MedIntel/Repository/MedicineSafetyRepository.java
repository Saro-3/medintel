package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineSafety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineSafetyRepository extends JpaRepository<MedicineSafety, Long> {
    MedicineSafety findByMedicine(Medicine medicine);
}
