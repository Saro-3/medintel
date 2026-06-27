package com.example.MedIntel.Service;

import com.example.MedIntel.Model.MedicineSafety;

import java.util.List;

public interface MedicineSafetyService {

    //Get safety details by ID
    MedicineSafety getMedicineSafetyById(Long id);

    //Get All safety records
    List<MedicineSafety> getAllMedicineSafety();

    //Save or update safety details
    MedicineSafety saveMedicineSafety(MedicineSafety medicineSafety);

    //Delete safety record by ID
    void deleteMedicineSafety(Long id);

    //Search safety info (pregnancy / lactation)
    List<MedicineSafety> getAllMedicineSafetyByName(String query);
}
