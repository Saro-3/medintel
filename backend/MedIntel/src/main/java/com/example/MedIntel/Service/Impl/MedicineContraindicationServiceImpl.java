package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicineContraindication;
import com.example.MedIntel.Repository.MedicineContraindicationRepository;
import com.example.MedIntel.Service.MedicineContraindicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class MedicineContraindicationServiceImpl implements MedicineContraindicationService {

    @Autowired
    private MedicineContraindicationRepository medicineContraindicationRepository;

    @Override
    public List<MedicineContraindication> getContraindicationsById(Long id) {

        return Collections.singletonList(medicineContraindicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found! " + id)
                ));
    }
}
