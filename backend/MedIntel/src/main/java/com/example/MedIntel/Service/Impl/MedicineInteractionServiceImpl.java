package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicineInteraction;
import com.example.MedIntel.Repository.MedicineInteractionRepository;
import com.example.MedIntel.Service.MedicineInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineInteractionServiceImpl implements MedicineInteractionService {

    @Autowired
    private MedicineInteractionRepository medicineInteractionRepository;

    @Override
    public MedicineInteraction getMedicineInteractionById(Long id) {
        return medicineInteractionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("MedicineInteraction with id: " + id + " not found!")
                );
    }

    @Override
    public List<MedicineInteraction> getAllMedicineInteraction() {
        return medicineInteractionRepository.findAll();
    }

    @Override
    public MedicineInteraction saveMedicineInteraction(MedicineInteraction medicineInteraction) {
        return medicineInteractionRepository.save(medicineInteraction);
    }

    @Override
    public void deleteMedicineInteractionById(Long id) {
        MedicineInteraction medicineInteraction = medicineInteractionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cannot delete. Medicine not found with id: " + id
                )
        );
        medicineInteractionRepository.delete(medicineInteraction);
    }

    @Override
    public List<MedicineInteraction> searchMedicineInteraction(String query) {
        return medicineInteractionRepository.findAll()
                .stream()
                .filter(mi ->
                        mi.getInteraction() != null &&
                                mi.getInteraction().toLowerCase().contains(query.toLowerCase())
                )
                .toList();
    }
}
