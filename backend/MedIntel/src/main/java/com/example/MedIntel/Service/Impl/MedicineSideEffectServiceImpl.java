package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicineSideEffect;
import com.example.MedIntel.Repository.MedicineSideEffectRepository;
import com.example.MedIntel.Service.MedicineSideEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineSideEffectServiceImpl implements MedicineSideEffectService {

    @Autowired
    MedicineSideEffectRepository medicineSideEffectRepository;

    @Override
    public MedicineSideEffect getMedicineSideEffectById(Long id) {
        return medicineSideEffectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found! " + id)
                );
    }

    @Override
    public List<MedicineSideEffect> getAllMedicineSideEffects() {
        return medicineSideEffectRepository.findAll();
    }

    @Override
    public MedicineSideEffect saveMedicineSideEffect(MedicineSideEffect medicineSideEffect) {
        return medicineSideEffectRepository.save(medicineSideEffect);
    }

    @Override
    public void deleteMedicineSideEffectById(Long id) {
        MedicineSideEffect medicineSideEffect = medicineSideEffectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cannot delete. Resource not found! " + id
                        )
                );
        medicineSideEffectRepository.delete(medicineSideEffect);
    }

    @Override
    public List<MedicineSideEffect> searchMedicineSideEffect(String query) {
        return medicineSideEffectRepository.findAll()
                .stream()
                .filter(se ->
                        se.getSideEffects() != null &&
                                se.getSideEffects().toLowerCase().contains(query.toLowerCase())
                )
                .toList();
    }
}
