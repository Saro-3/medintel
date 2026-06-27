package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicineIndication;
import com.example.MedIntel.Repository.MedicineIndicationRepository;
import com.example.MedIntel.Service.MedicineIndicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineIndicationServiceImpl implements MedicineIndicationService {

    @Autowired
    private MedicineIndicationRepository medicineIndicationRepository;


    @Override
    public MedicineIndication getMedicineIndicationById(Long id) {
        return medicineIndicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine Indication with id " + id + " not found!")
                );
    }

    @Override
    public List<MedicineIndication> getAllMedicineIndication() {
        return medicineIndicationRepository.findAll();
    }

    @Override
    public MedicineIndication saveMedicineIndication(MedicineIndication medicineIndication) {
        return medicineIndicationRepository.save(medicineIndication);
    }

    @Override
    public void deleteMedicineIndicationById(Long id) {
        MedicineIndication medicineIndication = medicineIndicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cannot delete. Medicine not found with id: " + id
                        )
                );
        medicineIndicationRepository.delete(medicineIndication);
    }

    @Override
    public List<MedicineIndication> searchMedicineIndication(String query) {
        return medicineIndicationRepository.findAll()
                .stream()
                .filter(i ->
                        i.getIndication() != null &&
                                i.getIndication().toLowerCase().contains(query.toLowerCase())
                )
                .toList();
    }
}
