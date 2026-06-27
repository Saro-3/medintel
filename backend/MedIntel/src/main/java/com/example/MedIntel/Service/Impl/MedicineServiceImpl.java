package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.DSA.MedicineIndex;
import com.example.MedIntel.DSA.MedicineSearchEngine;
import com.example.MedIntel.DSA.SubstanceGraph;
import com.example.MedIntel.DTO.MedicineDTO;
import com.example.MedIntel.DTO.MedicineFullResponseDTO;
import com.example.MedIntel.Exceptions.ResourceNotFoundException;
import com.example.MedIntel.Model.*;
import com.example.MedIntel.Repository.*;
import com.example.MedIntel.Service.MedicineService;
import com.example.MedIntel.Util.ImagePathUtil;
import com.example.MedIntel.Util.MedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository; // Inject Repository

    @Autowired
    private MedicineBrandRepository medicineBrandRepository;

    @Autowired
    private MedicineIndicationRepository medicineIndicationRepository;

    @Autowired
    private MedicineSideEffectRepository medicineSideEffectRepository;

    @Autowired
    private MedicineInteractionRepository medicineInteractionRepository;

    @Autowired
    private MedicineDosageRepository medicineDosageRepository;

    @Autowired
    private MedicineSafetyRepository medicineSafetyRepository;

    @Autowired
    private MedicineStorageRepository medicineStorageRepository;

    @Autowired
    private MedicineContraindicationRepository medicineContraindicationRepository;

    @Autowired
    private MedicinePrecautionRepository medicinePrecautionRepository;


    @Override
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found with id: " + id)
                );  // Return null if not found
    }

    @Override
    public Medicine getMedicineByName(String genericName) {
        return medicineRepository.findAll()
                .stream()
                .filter(m -> m.getGenericName().equalsIgnoreCase(genericName))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found with name: " + genericName
                        )
                );
    }

    @Override
    public List<MedicineDTO> getAllMedicines() {
        return medicineRepository.findAll()
                .stream()
                .map(MedicineMapper::toMedicineDTO)
                .toList();
    }

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        // 1️⃣ Save medicine first (ID gets generated)
        Medicine savedMedicine = medicineRepository.save(medicine);

        // 2️⃣ Set image URL using generated ID
        savedMedicine.setImageUrl(
                ImagePathUtil.medicineImage(savedMedicine.getId())
        );

        return medicineRepository.save(medicine);
    }

    @Override
    public void deleteMedicine(Long id) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cannot delete. Medicine not found with id: " + id
                        )
                );
    }

    @Override
    public List<Medicine> searchMedicine(String query) {

        //Simple search (Basic) - Later replaced by DSA + SQL indexes
        return medicineRepository.findAll()
                .stream()
                .filter(m -> m.getGenericName().toLowerCase().contains(query.toLowerCase())
                        || m.getApi().toLowerCase().contains(query.toLowerCase())
                        || m.getDrugClass().toLowerCase().contains(query.toLowerCase()))
                        .toList();
    }

    @Override
    public MedicineFullResponseDTO getFullMedicineDetails(Long medicineId) {

        //Get Medicine (Parent)
        Medicine medicine = medicineRepository.findById(medicineId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Medicine not found with id: " + medicineId
                        )
                );

        //Get Child data
        List<MedicineBrand> brands =
                medicineBrandRepository.findByMedicine(medicine);

        List<MedicineIndication> indications =
                medicineIndicationRepository.findByMedicine(medicine);

        List<MedicineSideEffect> sideEffects =
                medicineSideEffectRepository.findByMedicine(medicine);

        List<MedicineInteraction> interactions =
                medicineInteractionRepository.findByMedicine(medicine);

        MedicineDosage dosage =
                medicineDosageRepository.findByMedicine(medicine);

        MedicineSafety safety =
                medicineSafetyRepository.findByMedicine(medicine);

        MedicineStorage storage =
                medicineStorageRepository.findByMedicine(medicine);

        List<MedicineContraindication> contraindications =
                medicineContraindicationRepository.findByMedicine(medicine);

        List<MedicinePrecaution> precautions =
                medicinePrecautionRepository.findByMedicine(medicine);


        //Map Entity -> DTO using MedicineMapper
        MedicineFullResponseDTO response = new MedicineFullResponseDTO();

        response.setMedicine(MedicineMapper.toMedicineDTO(medicine));
        response.setBrands(MedicineMapper.toMedicineBrandDTOList(brands));
        response.setIndications(MedicineMapper.toMedicineIndicationDTOList(indications));
        response.setSideEffects(MedicineMapper.medicineSideEffectDTOList(sideEffects));
        response.setInteractions(MedicineMapper.medicineInteractionDTOList(interactions));
        response.setDosage(MedicineMapper.toMedicineDosageDTO(dosage));
        response.setSafety(MedicineMapper.toMedicineSafetyDTO(safety));
        response.setStorage(MedicineMapper.toMedicineStorageDTO(storage));
        response.setContraindications(MedicineMapper.toContraindicationDTOList(contraindications));
        response.setPrecautions(MedicineMapper.toPrecautionDTOList(precautions));


        return response;
    }

    @Override
    public MedicineDTO searchMedicineExact(String genericName) {

        if (genericName == null) {
            return null;
        }

        // 🔥 NORMALIZATION (THIS IS KEY)
        genericName = genericName.trim();

        System.out.println("🔍 Normalized search key: [" + genericName + "]");

        // 1️⃣ HashMap search
        MedicineDTO dto = MedicineIndex.searchByName(genericName);

        System.out.println("📦 HashMap result: " + dto);

        if (dto != null) {
            return dto;
        }

        // 2️⃣ DB fallback
        Medicine medicine =
                medicineRepository.findByGenericNameIgnoreCase(genericName);

        System.out.println("🗄️ DB result: " + medicine);

        if (medicine == null) {
            return null;
        }

        // 3️⃣ Map + cache
        dto = MedicineMapper.toMedicineDTO(medicine);
        MedicineIndex.addMedicine(dto);

        return dto;
    }

    @Override
    public List<String> searchMedicinePrefix(String prefix) {
        return MedicineSearchEngine.searchByPrefix(prefix);
    }

    @Override
    public List<String> getMedicineBySubstance(String substance) {
        return SubstanceGraph.getMedicinesBySubstance(substance);
    }

}
