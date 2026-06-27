package com.example.MedIntel.DTO;

import com.example.MedIntel.Model.MedicineSafety;

import java.util.List;

public class MedicineFullResponseDTO {

    //Core medicine info
    private MedicineDTO medicine;

    //One-to-Many data
    private List<MedicineBrandDTO> brands;
    private List<MedicineIndicationDTO> indications;
    private List<MedicineSideEffectDTO> sideEffects;
    private List<MedicineInteractionDTO> interactions;
    private List<MedicineContraindicationDTO> contraindications;
    private List<MedicinePrecautionDTO> precautions;

    //One-to-One data
    private MedicineDosageDTO dosage;
    private MedicineSafetyDTO safety;
    private MedicineStorageDTO storage;

    public MedicineFullResponseDTO(List<MedicinePrecautionDTO> precautions, List<MedicineContraindicationDTO> contraindications) {
        this.precautions = precautions;
        this.contraindications = contraindications;
    }

    //Constructors
    public MedicineFullResponseDTO(
            MedicineDTO medicine,
            MedicineStorageDTO storage,
            MedicineSafetyDTO safety,
            MedicineDosageDTO dosage,
            List<MedicineInteractionDTO> interactions,
            List<MedicineSideEffectDTO> sideEffects,
            List<MedicineIndicationDTO> indications,
            List<MedicineBrandDTO> brands

    ) {

        this.medicine = medicine;
        this.storage = storage;
        this.safety = safety;
        this.dosage = dosage;
        this.interactions = interactions;
        this.sideEffects = sideEffects;
        this.indications = indications;
        this.brands = brands;

    }

    public MedicineFullResponseDTO() {

    }

    public MedicineDTO getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineDTO medicine) {
        this.medicine = medicine;
    }

    public List<MedicineBrandDTO> getBrands() {
        return brands;
    }

    public void setBrands(List<MedicineBrandDTO> brands) {
        this.brands = brands;
    }

    public List<MedicineIndicationDTO> getIndications() {
        return indications;
    }

    public void setIndications(List<MedicineIndicationDTO> indications) {
        this.indications = indications;
    }

    public List<MedicineSideEffectDTO> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(List<MedicineSideEffectDTO> sideEffects) {
        this.sideEffects = sideEffects;
    }

    public List<MedicineInteractionDTO> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<MedicineInteractionDTO> interactions) {
        this.interactions = interactions;
    }

    public MedicineDosageDTO getDosage() {
        return dosage;
    }

    public void setDosage(MedicineDosageDTO dosage) {
        this.dosage = dosage;
    }

    public MedicineSafetyDTO getSafety() {
        return safety;
    }

    public void setSafety(MedicineSafetyDTO safety) {
        this.safety = safety;
    }

    public MedicineStorageDTO getStorage() {
        return storage;
    }

    public void setStorage(MedicineStorageDTO storage) {
        this.storage = storage;
    }

    public List<MedicineContraindicationDTO> getContraindications() {
        return contraindications;
    }

    public void setContraindications(List<MedicineContraindicationDTO> contraindications) {
        this.contraindications = contraindications;
    }

    public List<MedicinePrecautionDTO> getPrecautions() {
        return precautions;
    }

    public void setPrecautions(List<MedicinePrecautionDTO> precautions) {
        this.precautions = precautions;
    }
}
