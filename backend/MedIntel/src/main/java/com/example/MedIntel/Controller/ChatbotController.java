package com.example.MedIntel.Controller;

import com.example.MedIntel.DTO.MedicineDTO;
import com.example.MedIntel.Service.ChatbotService;
import com.example.MedIntel.Service.Impl.MedicineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatbot")
@CrossOrigin
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @Autowired
    private MedicineServiceImpl medicineServiceImpl;

    @GetMapping("/ask")
    public String ask(@RequestParam String message) {
        return chatbotService.getChatbotResponse(message);
    }

    //HashMap Exact Match GenericName
    @GetMapping("/search/exact")
    public MedicineDTO searchExact(@RequestParam String name) {
        System.out.println("searchExact");
        return medicineServiceImpl.searchMedicineExact(name);
    }

    //Binary Search Prefix
    @GetMapping("/search/prefix")
    public List<String> searchByPrefix(@RequestParam String q) {
        System.out.println("Binary Search Working...");
        return medicineServiceImpl.searchMedicinePrefix(q);
    }

    //Graph Search
    @GetMapping("/search/substance")
    public List<String> searchSubstance(@RequestParam String api) {
        System.out.println("searchSubstance");
        return medicineServiceImpl.getMedicineBySubstance(api);
    }
}
