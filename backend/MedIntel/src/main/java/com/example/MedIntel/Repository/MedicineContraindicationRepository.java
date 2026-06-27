package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineContraindication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineContraindicationRepository extends JpaRepository<MedicineContraindication, Long> {

    List<MedicineContraindication> findByMedicine(Medicine medicine);
}
