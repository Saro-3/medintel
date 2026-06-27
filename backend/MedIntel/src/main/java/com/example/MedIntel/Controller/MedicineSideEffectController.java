package com.example.MedIntel.Controller;


import com.example.MedIntel.Model.MedicineSideEffect;
import com.example.MedIntel.Service.MedicineSideEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/side-effects")
public class MedicineSideEffectController {

    @Autowired
    private MedicineSideEffectService medicineSideEffectService;

    @GetMapping
    public List<MedicineSideEffect> getAllMedicineSideEffects() {
        return medicineSideEffectService.getAllMedicineSideEffects();
    }

    @GetMapping("/{id}")
    public MedicineSideEffect getMedicineSideEffectById(@PathVariable Long id) {
        return medicineSideEffectService.getMedicineSideEffectById(id);
    }

    @GetMapping("/search")
    public List<MedicineSideEffect> getAllMedicineSideEffectsSearch(@RequestParam String query) {
        return medicineSideEffectService.searchMedicineSideEffect(query);
    }

    @PostMapping
    public MedicineSideEffect saveMedicineSideEffect(MedicineSideEffect medicineSideEffect) {
        return medicineSideEffectService.saveMedicineSideEffect(medicineSideEffect);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicineSideEffectById(@PathVariable Long id) {
        medicineSideEffectService.deleteMedicineSideEffectById(id);
    }
}
