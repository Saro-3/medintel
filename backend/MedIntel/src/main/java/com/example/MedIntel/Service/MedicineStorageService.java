package com.example.MedIntel.Service;

import com.example.MedIntel.Model.MedicineStorage;

import java.util.List;

public interface MedicineStorageService {

    //Get storage details by ID
    MedicineStorage getMedicineStorageById(Long id);

    //Get all storage records
    List<MedicineStorage> getAllMedicineStorage();

    //Save or update storage details
    MedicineStorage saveMedicineStorage(MedicineStorage medicineStorage);

    //Delete storage record by ID
    void deleteMedicineStorageById(Long id);

    //Search storage info (instructions / batch / expiry)
    List<MedicineStorage> searchMedicineStorage(String query);
}
