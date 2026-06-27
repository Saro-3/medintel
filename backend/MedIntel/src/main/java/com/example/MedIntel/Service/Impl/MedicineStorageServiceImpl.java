package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicineStorage;
import com.example.MedIntel.Repository.MedicineStorageRepository;
import com.example.MedIntel.Service.MedicineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineStorageServiceImpl implements MedicineStorageService {

    @Autowired
    private MedicineStorageRepository medicineStorageRepository;

    @Override
    public MedicineStorage getMedicineStorageById(Long id) {
        return medicineStorageRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found with id " + id)
                );
    }

    @Override
    public List<MedicineStorage> getAllMedicineStorage() {
        return medicineStorageRepository.findAll();
    }

    @Override
    public MedicineStorage saveMedicineStorage(MedicineStorage medicineStorage) {
        return medicineStorageRepository.save(medicineStorage);
    }

    @Override
    public void deleteMedicineStorageById(Long id) {
        MedicineStorage medicineStorage = medicineStorageRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cannot delete. Medicine not found with id " + id
                        )
                );
    }

    @Override
    public List<MedicineStorage> searchMedicineStorage(String query) {
        return medicineStorageRepository.findAll()
                .stream()
                .filter(mst ->
                        (mst.getStorageInstructions() != null &&
                                mst.getStorageInstructions().toLowerCase().contains(query.toLowerCase()))
                                ||
                                (mst.getBatchNumber() != null &&
                                        mst.getBatchNumber().toLowerCase().contains(query.toLowerCase()))
                                ||
                                (mst.getExpiryPeriod() != null &&
                                        mst.getExpiryPeriod().toLowerCase().contains(query.toLowerCase()))
                )
                .toList();
    }
}
