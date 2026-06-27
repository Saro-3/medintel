package com.example.MedIntel.Service;

import com.example.MedIntel.Model.MedicineSideEffect;

import java.util.List;

public interface MedicineSideEffectService {

    //Get one side effect by ID
    MedicineSideEffect getMedicineSideEffectById(Long id);

    //Get all side effects
    List<MedicineSideEffect> getAllMedicineSideEffects();

    //Save or add side effect
    MedicineSideEffect saveMedicineSideEffect(MedicineSideEffect medicineSideEffect);

    //Delete side effect by ID
    void deleteMedicineSideEffectById(Long id);

    //Search side effects text
    List<MedicineSideEffect> searchMedicineSideEffect(String query);
}
