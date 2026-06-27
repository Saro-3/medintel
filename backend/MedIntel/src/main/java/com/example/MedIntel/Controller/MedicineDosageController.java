package com.example.MedIntel.Controller;

import com.example.MedIntel.Model.MedicineDosage;
import com.example.MedIntel.Service.MedicineDosageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dosages")
public class MedicineDosageController {

    @Autowired
    private MedicineDosageService medicineDosageService;

    @GetMapping
    public List<MedicineDosage> getAllMedicineDosages(){
        return medicineDosageService.getAllMedicineDosage();
    }

    @GetMapping("/{id}")
    public MedicineDosage getMedicineDosageById(@PathVariable Long id){
        return medicineDosageService.getMedicineDosageById(id);
    }

    @GetMapping("/search")
    public List<MedicineDosage> searchMedicineDosages(@RequestParam String query){
        return medicineDosageService.searchMedicineDosage(query);
    }

    @PostMapping
    public MedicineDosage saveDosage(@RequestBody MedicineDosage medicineDosage){
        return medicineDosageService.saveMedicineDosage(medicineDosage);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicineDosageById(@PathVariable Long id){
        medicineDosageService.deleteMedicineDosage(id);
    }
}
