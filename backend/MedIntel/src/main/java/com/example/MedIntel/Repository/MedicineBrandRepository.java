package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineBrandRepository extends JpaRepository<MedicineBrand, Long> {

    List<MedicineBrand> findByMedicine(Medicine medicine);
}
