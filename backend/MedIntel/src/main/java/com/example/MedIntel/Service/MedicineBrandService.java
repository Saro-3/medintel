package com.example.MedIntel.Service;

import com.example.MedIntel.Model.MedicineBrand;

import java.util.List;

public interface MedicineBrandService {

    // Get MedicineBrand id to find it
    MedicineBrand getMedicineBrandById(Long id);

    // Get Medicine Brand by Name
    MedicineBrand getMedicineBrandByBrandName(String brandName);

    //Save or add a new Medicine Brand
    MedicineBrand saveMedicineBrand(MedicineBrand medicineBrand);

    //Delete a medicine by ID
    void deleteMedicineBrand(Long id);

    //Get List of all MedicineBrand
    List<MedicineBrand> getAllMedicineBrand();

    //Search Medicine (DSA Layer + MySQL)
    List<MedicineBrand> searchMedicineBrand(String query);
}
