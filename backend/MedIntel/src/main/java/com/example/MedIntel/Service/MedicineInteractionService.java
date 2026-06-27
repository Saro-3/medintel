package com.example.MedIntel.Service;

import com.example.MedIntel.Model.MedicineInteraction;

import java.util.List;

public interface MedicineInteractionService {

    //Get one interaction by id
    MedicineInteraction getMedicineInteractionById(Long id);

    //Get all interactions
    List<MedicineInteraction> getAllMedicineInteraction();

    //Save or add interaction
    MedicineInteraction saveMedicineInteraction(MedicineInteraction medicineInteraction);

    //Delete interaction by ID
    void deleteMedicineInteractionById(Long id);

    //Search interaction text
    List<MedicineInteraction> searchMedicineInteraction(String name);

}
