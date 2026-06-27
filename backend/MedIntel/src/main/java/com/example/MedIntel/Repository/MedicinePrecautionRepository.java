package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicinePrecaution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicinePrecautionRepository extends JpaRepository<MedicinePrecaution, Long> {

    List<MedicinePrecaution> findByMedicine(Medicine medicine);
}
