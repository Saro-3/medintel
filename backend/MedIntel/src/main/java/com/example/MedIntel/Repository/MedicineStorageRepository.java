package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineStorage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineStorageRepository extends JpaRepository<MedicineStorage, Long> {
    MedicineStorage findByMedicine(Medicine medicine);
}
