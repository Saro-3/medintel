package com.example.MedIntel.Controller;

import com.example.MedIntel.Model.MedicinePrecaution;
import com.example.MedIntel.Service.MedicinePrecautionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/precautions")
public class MedicinePrecautionController {

    @Autowired
    private MedicinePrecautionService medicinePrecautionService;

    @GetMapping("/{id}/precautions")
    public List<MedicinePrecaution> getPrecautions(@PathVariable Long id) {
        return medicinePrecautionService.getPrecautionsById(id);
    }
}
