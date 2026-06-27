package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineIndication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineIndicationRepository extends JpaRepository<MedicineIndication, Long> {

    List<MedicineIndication> findByMedicine(Medicine medicine);
}
