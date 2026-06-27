package com.example.MedIntel.Controller;

import com.example.MedIntel.Model.MedicineBrand;
import com.example.MedIntel.Service.MedicineBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class MedicineBrandController {

    @Autowired
    private MedicineBrandService medicineBrandService;

    //Get all brands
    public List<MedicineBrand> getAllBrands() {
        return medicineBrandService.getAllMedicineBrand();
    }

    //Get brand by ID
    @GetMapping("/{id}")
    public MedicineBrand getBrandById(@PathVariable Long id) {
        return medicineBrandService.getMedicineBrandById(id);
    }

    //Search brand
    @GetMapping("/search")
    public List<MedicineBrand> searchMedicineBrand(@RequestParam String query) {
        return medicineBrandService.searchMedicineBrand(query);
    }

    //Save brand
    @PostMapping
    public MedicineBrand saveBrand(@RequestBody MedicineBrand medicineBrand) {
        return medicineBrandService.saveMedicineBrand(medicineBrand);
    }


}
