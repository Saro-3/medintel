package com.example.MedIntel.Controller;

import com.example.MedIntel.Model.MedicineInteraction;
import com.example.MedIntel.Service.MedicineInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interaction")
public class MedicineInteractionController {

    @Autowired
    private MedicineInteractionService medicineInteractionService;

    @GetMapping
    public List<MedicineInteraction> getAllInteractions() {
        return medicineInteractionService.getAllMedicineInteraction();
    }

    @GetMapping("/{id}")
    public MedicineInteraction getInteractionById(@PathVariable Long id) {
        return medicineInteractionService.getMedicineInteractionById(id);
    }

    @GetMapping("/search")
    public List<MedicineInteraction> searchMedicineInteractionByName(String query){
        return medicineInteractionService.searchMedicineInteraction(query);
    }

    @PostMapping
    public MedicineInteraction saveMedicineInteraction(@RequestBody MedicineInteraction medicineInteraction){
        return medicineInteractionService.saveMedicineInteraction(medicineInteraction);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicineInteractionById(@PathVariable Long id){
        medicineInteractionService.deleteMedicineInteractionById(id);
    }
}
