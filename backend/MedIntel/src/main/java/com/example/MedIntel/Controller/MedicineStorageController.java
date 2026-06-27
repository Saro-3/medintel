package com.example.MedIntel.Controller;

import com.example.MedIntel.Model.MedicineStorage;
import com.example.MedIntel.Service.MedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class MedicineStorageController {

    @Autowired
    private MedicineStorageService medicineStorageService;

    @GetMapping
    public List<MedicineStorage> getAllMedicineSafety() {
        return medicineStorageService.getAllMedicineStorage();
    }

    @GetMapping("/{id}")
    public MedicineStorage getMedicineSafety(@PathVariable Long id) {
        return medicineStorageService.getMedicineStorageById(id);
    }

    @GetMapping("/search")
    public List<MedicineStorage> searchMedicineSafety(@RequestParam String query) {
        return medicineStorageService.searchMedicineStorage(query);
    }

    @PostMapping
    public void saveMedicineSafety(@RequestBody MedicineStorage medicineStorage) {
        medicineStorageService.saveMedicineStorage(medicineStorage);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicineSafety(@PathVariable Long id) {
        medicineStorageService.deleteMedicineStorageById(id);
    }
}
