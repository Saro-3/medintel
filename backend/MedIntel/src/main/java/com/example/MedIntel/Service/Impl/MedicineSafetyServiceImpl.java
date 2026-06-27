package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicineSafety;
import com.example.MedIntel.Repository.MedicineSafetyRepository;
import com.example.MedIntel.Service.MedicineSafetyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineSafetyServiceImpl implements MedicineSafetyService {

    @Autowired
    private MedicineSafetyRepository medicineSafetyRepository;

    @Override
    public MedicineSafety getMedicineSafetyById(Long id) {
        return medicineSafetyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found! " + id)
                );
    }

    @Override
    public List<MedicineSafety> getAllMedicineSafety() {
        return medicineSafetyRepository.findAll();
    }

    @Override
    public MedicineSafety saveMedicineSafety(MedicineSafety medicineSafety) {
        return medicineSafetyRepository.save(medicineSafety);
    }

    @Override
    public void deleteMedicineSafety(Long id) {
       MedicineSafety medicineSafety = medicineSafetyRepository.findById(id)
               .orElseThrow(() ->
                       new ResourceNotFoundException(
                               "Cannot delete. Medicine not found with id: " + id
                       )
               );
       medicineSafetyRepository.delete(medicineSafety);
    }

    @Override
    public List<MedicineSafety> getAllMedicineSafetyByName(String query) {
        return medicineSafetyRepository.findAll()
                .stream()
                .filter(ms ->
                        (ms.getPregnancyCategory() != null &&
                                ms.getPregnancyCategory().toLowerCase().contains(query.toLowerCase()))
                                ||
                                (ms.getLactationSafety() != null &&
                                        ms.getLactationSafety().toLowerCase().contains(query.toLowerCase()))
                )
                .toList();
    }
}
