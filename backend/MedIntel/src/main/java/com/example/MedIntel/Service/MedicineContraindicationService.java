package com.example.MedIntel.Service;

import com.example.MedIntel.DTO.MedicineContraindicationDTO;
import com.example.MedIntel.Model.MedicineContraindication;

import java.util.List;

public interface MedicineContraindicationService {

    List<MedicineContraindication> getContraindicationsById(Long id);
}
