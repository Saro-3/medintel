package com.example.MedIntel.Service;

import com.example.MedIntel.Model.MedicineIndication;

import java.util.List;

public interface MedicineIndicationService {

    //Get one indication by ID
    MedicineIndication getMedicineIndicationById(Long id);

    //Get all indications
    List<MedicineIndication> getAllMedicineIndication();

    //save or add indication
    MedicineIndication saveMedicineIndication(MedicineIndication medicineIndication);

    //Delete indication by ID
    void deleteMedicineIndicationById(Long id);

    //Search indication text
    List<MedicineIndication> searchMedicineIndication(String query);

}
