package com.example.MedIntel.Controller;

import com.example.MedIntel.Model.MedicineIndication;
import com.example.MedIntel.Service.MedicineIndicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/indications")
public class MedicineIndicationController {

    @Autowired
    private MedicineIndicationService medicineIndicationService;

    @GetMapping
    public List<MedicineIndication> getAllMedicineIndication() {
        return medicineIndicationService.getAllMedicineIndication();
    }

    @GetMapping("{id}")
    public MedicineIndication getMedicineIndicationById(@PathVariable Long id) {
        return medicineIndicationService.getMedicineIndicationById(id);
    }

    @GetMapping("/search")
    public List<MedicineIndication> searchMedicineIndication(@RequestParam String query) {
        return medicineIndicationService.searchMedicineIndication(query);
    }

    @PostMapping
    public MedicineIndication saveMedicineIndication(MedicineIndication medicineIndication) {
        return medicineIndicationService.saveMedicineIndication(medicineIndication);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicineIndicationById(@PathVariable Long id) {
        medicineIndicationService.deleteMedicineIndicationById(id);
    }
}
