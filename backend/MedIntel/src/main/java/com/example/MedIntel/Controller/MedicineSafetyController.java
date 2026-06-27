package com.example.MedIntel.Controller;

import com.example.MedIntel.Model.MedicineSafety;
import com.example.MedIntel.Service.MedicineSafetyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/safety")
public class MedicineSafetyController {

    @Autowired
    private MedicineSafetyService medicineSafetyService;

    @GetMapping
    public List<MedicineSafety> getAllMedicineSafety(){
        return medicineSafetyService.getAllMedicineSafety();
    }

    @GetMapping("/{id}")
    public MedicineSafety getMedicineSafetyById(@PathVariable Long id){
        return medicineSafetyService.getMedicineSafetyById(id);
    }

    @GetMapping("/search")
    public List<MedicineSafety> searchMedicineSafetyByName(String query){
        return medicineSafetyService.getAllMedicineSafetyByName(query);
    }

    @PostMapping
    public MedicineSafety saveSafety(@RequestBody MedicineSafety medicineSafety){
        return medicineSafetyService.saveMedicineSafety(medicineSafety);
    }

    @DeleteMapping("/{id}")
    public void deleteSafetyById(@PathVariable Long id){
        medicineSafetyService.deleteMedicineSafety(id);
    }
}
