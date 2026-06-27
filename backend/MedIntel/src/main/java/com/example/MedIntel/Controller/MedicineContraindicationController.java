package com.example.MedIntel.Controller;

import com.example.MedIntel.DTO.MedicineContraindicationDTO;
import com.example.MedIntel.Model.MedicineContraindication;
import com.example.MedIntel.Service.MedicineContraindicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contraindication")
public class MedicineContraindicationController {

    @Autowired
    private MedicineContraindicationService medicineContraindicationService;

    @GetMapping("/{id}/contraindications")
    public List<MedicineContraindication> getMedicineContraindication(@PathVariable Long id) {
        return medicineContraindicationService.getContraindicationsById(id);
    }
}
