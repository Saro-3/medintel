package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicineDosage;
import com.example.MedIntel.Repository.MedicineDosageRepository;
import com.example.MedIntel.Service.MedicineDosageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineDosageServiceImpl implements MedicineDosageService {

    @Autowired
    private MedicineDosageRepository medicineDosageRepository;

    @Override
    public MedicineDosage getMedicineDosageById(Long id) {
        return medicineDosageRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found! " + id)
                );
    }

    @Override
    public List<MedicineDosage> getAllMedicineDosage() {
        return medicineDosageRepository.findAll();
    }

    @Override
    public MedicineDosage saveMedicineDosage(MedicineDosage medicineDosage) {
        return medicineDosageRepository.save(medicineDosage);
    }

    @Override
    public void deleteMedicineDosage(Long id) {
        MedicineDosage medicineDosage = medicineDosageRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cannot delete. Medicine not found with id: " + id
                        )
                );
        medicineDosageRepository.delete(medicineDosage);
    }

    @Override
    public List<MedicineDosage> searchMedicineDosage(String query) {
        return medicineDosageRepository.findAll()
                .stream()
                .filter(d ->
                        (d.getAdultDose() != null && d.getAdultDose().toLowerCase().contains(query.toLowerCase())) ||
                                (d.getChildDose() != null && d.getChildDose().toLowerCase().contains(query.toLowerCase())) ||
                                (d.getMaxDose() != null && d.getMaxDose().toLowerCase().contains(query.toLowerCase()))

                )
                .toList();
    }
}
