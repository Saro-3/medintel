package com.example.MedIntel.Service;

import com.example.MedIntel.Model.MedicineDosage;

import java.util.List;

public interface MedicineDosageService {

    //Get one medicineDosage using its ID
    MedicineDosage getMedicineDosageById(Long id);

    //Get list of all medicinesDosage
    List<MedicineDosage> getAllMedicineDosage();

    //save or add a new medicineDosage
    MedicineDosage saveMedicineDosage(MedicineDosage medicineDosage);

    //Delete a medicineDosage by ID
    void deleteMedicineDosage(Long id);

    //Search medicineDosage (DSA layer + MySQL)
    List<MedicineDosage> searchMedicineDosage(String query);
}
