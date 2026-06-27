package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.MedicineBrand;
import com.example.MedIntel.Repository.MedicineBrandRepository;
import com.example.MedIntel.Service.MedicineBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineBrandServiceImpl implements MedicineBrandService {

    @Autowired
    private MedicineBrandRepository medicineBrandRepository;

    @Override
    public MedicineBrand getMedicineBrandById(Long id) {
        return medicineBrandRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found! " + id)
                );
    }

    @Override
    public MedicineBrand getMedicineBrandByBrandName(String brandName) {
        return medicineBrandRepository.findAll()
                .stream()
                .filter(m -> m.getBrandName().equalsIgnoreCase(brandName))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resource not found! " + brandName
                        )
                );
    }

    @Override
    public MedicineBrand saveMedicineBrand(MedicineBrand medicineBrand) {
        return medicineBrandRepository.save(medicineBrand);
    }

    @Override
    public void deleteMedicineBrand(Long id) {
        MedicineBrand medicineBrand = medicineBrandRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cannot delete. Medicine not found with id: " + id
                        )
                );
        medicineBrandRepository.delete(medicineBrand);
    }

    @Override
    public List<MedicineBrand> getAllMedicineBrand() {
        return medicineBrandRepository.findAll();
    }

    @Override
    public List<MedicineBrand> searchMedicineBrand(String query) {
        return medicineBrandRepository.findAll()
                .stream()
                .filter(m -> m.getBrandName().toLowerCase().contains(query.toLowerCase())
                        || m.getManufacturer().toLowerCase().contains(query.toLowerCase())
                        || m.getPrice().toString().contains(query.toLowerCase()))
                .toList();
    }
}
