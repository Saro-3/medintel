package com.example.MedIntel.Controller;


import com.example.MedIntel.DSA.MedicineIndex;
import com.example.MedIntel.DTO.MedicineDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class HelloController {
    @GetMapping
    public String hello() {
        MedicineDTO dto = MedicineIndex.searchByName("paracetamol");
        System.out.println(dto);
        return "Backend Running Successfully!";
    }
}
