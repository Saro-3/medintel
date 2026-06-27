package com.example.MedIntel.Controller;

import com.example.MedIntel.DTO.MedicineDTO;
import com.example.MedIntel.DTO.MedicineFullResponseDTO;
import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Service.Impl.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineServiceImpl medicineServiceImpl;

    @GetMapping("/{id}/full")
    public MedicineFullResponseDTO getFullMedicineDetails(@PathVariable Long id){
        System.out.println("getFullMedicineDetails");
        return medicineServiceImpl.getFullMedicineDetails(id);
    }

    //Get all medicines
    @GetMapping
    public List<MedicineDTO> getAllMedicines() {
        System.out.println("GET ALL MEDICINES");
        return medicineServiceImpl.getAllMedicines();
    }

    //Get medicine by id
    @GetMapping("/{id}")
    public Medicine getMedicinesById(@PathVariable Long id) {
        return medicineServiceImpl.getMedicineById(id);
    }

    //Search medicines
    @GetMapping("/search")
    public List<Medicine> searchMedicines(@RequestParam String query) {
        return medicineServiceImpl.searchMedicine(query);
    }

    //HashMap Exact Match GenericName
    @GetMapping("/search/exact")
    public MedicineDTO searchExact(@RequestParam String name) {
        System.out.println("searchExact");
        return medicineServiceImpl.searchMedicineExact(name);
    }

    //Binary Search Prefix
    @GetMapping("/search/prefix")
    public List<String> searchByPrefix(@RequestParam String q) {
        System.out.println("Binary Search Working...");
        return medicineServiceImpl.searchMedicinePrefix(q);
    }

    //Graph Search
    @GetMapping("/search/substance")
    public List<String> searchSubstance(@RequestParam String api) {
        System.out.println("searchSubstance");
        return medicineServiceImpl.getMedicineBySubstance(api);
    }

    //Add New medicine
    @PostMapping
    public Medicine saveMedicine(@RequestBody Medicine medicine) {
        return medicineServiceImpl.saveMedicine(medicine);
    }

    //Delete medicine
    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable Long id) {
        medicineServiceImpl.deleteMedicine(id);
    }
}
