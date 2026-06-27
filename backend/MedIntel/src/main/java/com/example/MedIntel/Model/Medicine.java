package com.example.MedIntel.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "generic_name")
    private String genericName;

    @Column(name = "strength")
    private String strength;

    @Column(name = "dosage_form")
    private String dosageForm;

    @Column(name = "api")
    private String api;

    @Column(name = "drug_class")
    private String drugClass;

    @Column(name = "composition")
    private String composition;

    @Column(name = "schedule")
    private String schedule;

    @PrePersist
    public void insertTime() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;  // assign value
        updatedAt = now; // assign value
    }

    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @PreUpdate
    public void updateTime() {
        updatedAt = LocalDateTime.now();
    }
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "image_url")
    private String imageUrl;

}
