package com.example.MedIntel.Service.Impl;

import com.example.MedIntel.DSA.BrandGenericIndex;
import com.example.MedIntel.DSA.MedicineIndex;
import com.example.MedIntel.DSA.SubstanceGraph;
import com.example.MedIntel.DTO.MedicineDTO;
import com.example.MedIntel.Service.ChatbotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatbotServiceImpl implements ChatbotService {

    @Override
    public String getChatbotResponse(String userMessage) {

        if (userMessage == null || userMessage.isBlank()) {
            return "Please ask a valid medicine-related question! Thank you";
        }

        String message = userMessage.toLowerCase().trim();

        // Intent: Substance-based question
        if (message.contains("contains") || message.contains("having")) {

            String substance = extractLastWord(message);
            List<String> medicines =
                    SubstanceGraph.getMedicinesBySubstance(substance);

            if (medicines.isEmpty()) {
                return "I could not find medicines containing " + substance + ".";
            }

            return "Medicines containing " + substance + "are: "
                    + String.join(", ", medicines);
        }

        // Intent: Exact medicine info
        MedicineDTO medicine = MedicineIndex.searchByName(message);

        if (medicine != null) {
            return "Medicine found: " + medicine.getGenericName()
                    + ". Strength: " + medicine.getStrength()
                    + ", Form: " + medicine.getDosageForm();
        }

        //Brand -> Generic intelligence
        String generic = BrandGenericIndex.getGenericByBrand(message);
        if (generic != null) {

            MedicineDTO genericMedicine =
                    MedicineIndex.searchByName(generic);

            if (genericMedicine != null) {
                return message.toUpperCase() + " is a brand of "
                        + genericMedicine.getGenericName()
                        + ", Strength: " + genericMedicine.getStrength();
            }

            return message + " is a brand of " + generic;
        }

        // Smart Fallback
        List<String> suggestions =
                com.example.MedIntel.DSA.MedicineSearchEngine.searchByPrefix(message);
        if (suggestions.isEmpty()) {
            return "I could not find \"" + userMessage + "\" in my database. \n"
                    + "Did you mean: " + String.join(", ", suggestions) + " ?";
        }

        return "This medicine is not available in our database yet.\n"
                + "You can search by generic name or try autocomplete.";
    }

    //Helper: extract last word (simple NLP)
    private String extractLastWord(String message) {
        String[] words = message.split(" ");
        return words[words.length - 1];
    }
}
