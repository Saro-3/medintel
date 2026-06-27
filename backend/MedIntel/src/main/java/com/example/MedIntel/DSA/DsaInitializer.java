package com.example.MedIntel.DSA;

import com.example.MedIntel.DTO.MedicineDTO;
import com.example.MedIntel.Model.Medicine;
import com.example.MedIntel.Model.MedicineBrand;
import com.example.MedIntel.Repository.MedicineBrandRepository;
import com.example.MedIntel.Repository.MedicineRepository;
import com.example.MedIntel.Util.MedicineMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DsaInitializer {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicineBrandRepository medicineBrandRepository;

    @PostConstruct
    public void loadMedicineIndex() {

        // Clear old data (safe reload)
        MedicineIndex.clear();

        // Load all medicines from DB
        List<Medicine> medicines = medicineRepository.findAll();

        //Load all Medicine Brand from DB
        List<MedicineBrand> brands = medicineBrandRepository.findAll();

        List<String> names = new ArrayList<>();

        // Map & Index
        for (Medicine medicine : medicines) {
            MedicineDTO dto = MedicineMapper.toMedicineDTO(medicine);

            //HashMap
            MedicineIndex.addMedicine(dto);

            // Binary Search list
            names.add(dto.getGenericName());

            // Graph Relation
            SubstanceGraph.addRelation(
                    medicine.getApi(),          // substance
                    medicine.getGenericName()   // medicine name
            );
        }

        for (MedicineBrand brand : brands) {
            BrandGenericIndex.addBrand(
                    brand.getBrandName(),
                    brand.getMedicine().getGenericName()
            );
        }


        MedicineSearchEngine.loadNames(names);

        // Optional Log
        System.out.println("✅ DSA initialized:");
        System.out.println("   HashMap size: " + MedicineIndex.size());
        System.out.println("   Binary list size: " + names.size());
        System.out.println("   Graph size (substances): " + SubstanceGraph.size());
        System.out.println("   Brand -> Generic index size " + BrandGenericIndex.size());
    }


}
