package com.example.MedIntel.Repository;

import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineSideEffect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MedicineSideEffectRepository extends JpaRepository<MedicineSideEffect, Long> {

    List<MedicineSideEffect> findByMedicine(Medicine medicine);
}
