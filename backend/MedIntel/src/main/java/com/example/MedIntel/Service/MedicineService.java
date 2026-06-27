package com.example.MedIntel.Service;

import com.example.MedIntel.DTO.MedicineDTO;
import com.example.MedIntel.DTO.MedicineFullResponseDTO;
import com.example.MedIntel.Model.Medicine;
import java.util.List;

public interface MedicineService  {

    //Get one medicine using its ID
    Medicine getMedicineById(Long id);

    //Get medicine using generic name
    Medicine getMedicineByName(String genericName);

    //Get list of all medicines
    List<MedicineDTO> getAllMedicines();

    //save or add a new medicine
    Medicine saveMedicine(Medicine medicine);

    //Delete a medicine by ID
    void deleteMedicine(Long id);

    //Search medicine (DSA layer + MySQL)
    List<Medicine> searchMedicine(String query);

    // Full medicine details
    MedicineFullResponseDTO getFullMedicineDetails(Long medicineId);

    //DSA-Powered exact search HashMap
    MedicineDTO searchMedicineExact(String genericName);

    //Binary Search Prefix
    List<String> searchMedicinePrefix(String prefix);

    //Graph Search
    List<String> getMedicineBySubstance(String substance);
}
