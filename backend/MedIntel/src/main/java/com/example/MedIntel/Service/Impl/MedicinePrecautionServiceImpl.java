package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicinePrecaution;
import com.example.MedIntel.Repository.MedicinePrecautionRepository;
import com.example.MedIntel.Service.MedicinePrecautionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MedicinePrecautionServiceImpl implements MedicinePrecautionService {

    @Autowired
    private MedicinePrecautionRepository medicinePrecautionRepository;

    @Override
    public List<MedicinePrecaution> getPrecautionsById(Long id) {

        return Collections.singletonList(medicinePrecautionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found! " + id)
                ));
    }
}
