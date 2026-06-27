package com.example.MedIntel.DSA;

import com.example.MedIntel.DTO.MedicineDTO;

import java.util.HashMap;
import java.util.Map;

public class MedicineIndex {

    // Key -> generic name (lowercase)
    // Value -> MedicineDTO
    private static final Map<String, MedicineDTO> medicineMap = new HashMap<>(); //Object Creation

    //Prevent Object Creation
    private MedicineIndex() {}

    // Add Medicine to Index
    public static void addMedicine(MedicineDTO medicineDTO) {
        if (medicineDTO == null || medicineDTO.getGenericName() == null) {
            return;
        }
        medicineMap.put(
                medicineDTO.getGenericName().trim().toLowerCase(),
                medicineDTO
        );
    }

    // 0(1) exact search
    public static MedicineDTO searchByName(String name) {
        if (name == null) {
            return null;
        }
        return medicineMap.get(name.toLowerCase());
    }

    // Clear Index (used on reload)
    public static void clear() {
        medicineMap.clear();
    }

    // Debug / Status
    public static int size() {
        return medicineMap.size();
    }
}
