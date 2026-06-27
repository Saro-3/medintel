package com.example.MedIntel.Util;

import com.example.MedIntel.DTO.*;
import com.example.MedIntel.Model.*;

import java.util.List;
import java.util.stream.Collectors;

public class MedicineMapper {

    //Prevent object creation
    private MedicineMapper() {
    }

    //Medicine Entity -> MedicineDTO
    public static MedicineDTO toMedicineDTO(Medicine medicine) {

        if (medicine == null) {
            return null;
        }

        MedicineDTO dto = new MedicineDTO();
        dto.setId(medicine.getId());
        dto.setGenericName(medicine.getGenericName());
        dto.setStrength(medicine.getStrength());
        dto.setDosageForm(medicine.getDosageForm());
        dto.setApi(medicine.getApi());
        dto.setDrugClass(medicine.getDrugClass());
        dto.setComposition(medicine.getComposition());
        dto.setImageUrl(medicine.getImageUrl());


        return dto;
    }

    //MedicineBrand -> MedicineBrandDTO
    public static MedicineBrandDTO toMedicineBrandDTO(MedicineBrand medicineBrand) {

        if (medicineBrand == null) {
            return null;
        }

        MedicineBrandDTO dto =  new MedicineBrandDTO();
        dto.setId(medicineBrand.getId());
        dto.setBrandName(medicineBrand.getBrandName());
        dto.setManufacturer(medicineBrand.getManufacturer());
        dto.setPrice(medicineBrand.getPrice());

        return  dto;
    }

    //List<MedicineBrand> -> List<MedicineBrandDTO>
    public static List<MedicineBrandDTO> toMedicineBrandDTOList(List<MedicineBrand> medicineBrands) {

        if (medicineBrands == null) {
            return null;
        }

        return medicineBrands.stream()
                .map(MedicineMapper::toMedicineBrandDTO)
                .collect(Collectors.toList());
    }

    //MedicineIndication -> MedicineIndicationDTO
    public static MedicineIndicationDTO toMedicineIndicationDTO(MedicineIndication medicineIndication) {

        if (medicineIndication == null) {
            return null;
        }

        MedicineIndicationDTO dto = new MedicineIndicationDTO();

        dto.setId(medicineIndication.getId());
        dto.setIndication(medicineIndication.getIndication());

        return  dto;
    }

    //List<MedicineIndication> → List<MedicineIndicationDTO>
    public static List<MedicineIndicationDTO> toMedicineIndicationDTOList(List<MedicineIndication> medicineIndications) {

        if (medicineIndications == null) {
            return null;
        }

        return medicineIndications.stream()
                .map(MedicineMapper::toMedicineIndicationDTO)
                .collect(Collectors.toList());
    }

    //MedicineSideEffect -> MedicineSideEffectDTO
    public static MedicineSideEffectDTO toMedicineSideEffectDTO(MedicineSideEffect medicineSideEffect) {

        if (medicineSideEffect == null) {
            return null;
        }

        MedicineSideEffectDTO dto = new MedicineSideEffectDTO();
        dto.setId(medicineSideEffect.getId());
        dto.setSideEffect(medicineSideEffect.getSideEffects());

        return  dto;
    }

    //List<MedicineSideEffect> → List<MedicineSideEffectDTO>
    public static List<MedicineSideEffectDTO> medicineSideEffectDTOList(List<MedicineSideEffect> medicineSideEffects) {

        if (medicineSideEffects == null) {
            return null;
        }

        return medicineSideEffects.stream()
                .map(MedicineMapper::toMedicineSideEffectDTO)
                .collect(Collectors.toList());
    }

    //MedicineInteraction → MedicineInteractionDTO
    public static MedicineInteractionDTO toMedicineInteractionDTO(MedicineInteraction medicineInteraction) {

        if (medicineInteraction == null) {
            return null;
        }

        MedicineInteractionDTO dto = new MedicineInteractionDTO();
        dto.setId(medicineInteraction.getId());
        dto.setInteraction(medicineInteraction.getInteraction());

        return dto;
    }

    //List<MedicineInteraction> → List<MedicineInteractionDTO>
    public static List<MedicineInteractionDTO> medicineInteractionDTOList(List<MedicineInteraction> medicineInteractions) {

        if (medicineInteractions == null) {
            return null;
        }

        return medicineInteractions.stream()
                .map(MedicineMapper::toMedicineInteractionDTO)
                .collect(Collectors.toList());
    }

    //MedicineDosage -> MedicineDosageDTO
    public static MedicineDosageDTO toMedicineDosageDTO(MedicineDosage medicineDosage) {

        if (medicineDosage == null) {
            return null;
        }

        MedicineDosageDTO dto = new MedicineDosageDTO();
        dto.setId(medicineDosage.getId());
        dto.setAdultDose(medicineDosage.getAdultDose());
        dto.setChildDose(medicineDosage.getChildDose());
        dto.setMaxDose(medicineDosage.getMaxDose());

        return  dto;
    }

    // MedicineSafety -> MedicineSafetyDTO
    public static MedicineSafetyDTO toMedicineSafetyDTO(MedicineSafety safety) {

        if (safety == null) {
            return null;
        }

        MedicineSafetyDTO dto = new MedicineSafetyDTO();
        dto.setId(safety.getId());
        dto.setPregnancyCategory(safety.getPregnancyCategory());
        dto.setLactationSafety(safety.getLactationSafety());

        return  dto;
    }

    //MedicineStorage → MedicineStorageDTO
    public static MedicineStorageDTO toMedicineStorageDTO(MedicineStorage medicineStorage) {

        if (medicineStorage == null) {
            return null;
        }

        MedicineStorageDTO dto = new MedicineStorageDTO();
        dto.setId(medicineStorage.getId());
        dto.setStorageInstruction(medicineStorage.getStorageInstructions());
        dto.setExpiryPeriod(medicineStorage.getExpiryPeriod());
        dto.setBatchNumber(String.valueOf(medicineStorage.getBatchNumber()));

        return  dto;
    }

    //MedicineContraindication -> MedicineContraindicationDTO
    // SINGLE entity → DTO
    public static MedicineContraindicationDTO toContraindicationDTO(
            MedicineContraindication entity) {

        if (entity == null) return null;

        MedicineContraindicationDTO dto = new MedicineContraindicationDTO();
        dto.setId(entity.getId());
        dto.setContraindication(entity.getContraindication());
        return dto;
    }

    // LIST entity → LIST DTO
    public static List<MedicineContraindicationDTO> toContraindicationDTOList(
            List<MedicineContraindication> entities) {

        if (entities == null) return List.of();

        return entities.stream()
                .map(MedicineMapper::toContraindicationDTO) // ✅ THIS LINE
                .toList();
    }

    //MedicinePrecaution -> MedicinePrecautionDTO
    public static MedicinePrecautionDTO toPrecautionDTO(MedicinePrecaution entity) {

        if (entity == null) {
            return null;
        }

        MedicinePrecautionDTO dto = new MedicinePrecautionDTO();
        dto.setId(entity.getId());
        dto.setPrecaution(entity.getPrecaution());
        return dto;
    }

    public static List<MedicinePrecautionDTO> toPrecautionDTOList(
            List<MedicinePrecaution> entities) {

        if (entities == null) return List.of();

        return entities.stream()
                .map(MedicineMapper::toPrecautionDTO) // ✅ THIS LINE
                .toList();
    }

}
