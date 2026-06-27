package com.example.MedIntel.DSA;

import java.util.HashMap;
import java.util.Map;

public class BrandGenericIndex {

    //brand name -> generic name
    private static final Map<String, String>  brandToGeneric = new HashMap<>();

    private BrandGenericIndex() {}

    public static void addBrand(String brandName, String genericName) {
        if (brandName == null || genericName == null) return;

        brandToGeneric.put(
                brandName.trim().toLowerCase(),
                genericName.trim()
        );
    }

    public static String getGenericByBrand(String brandName) {
        if (brandName == null) return null;

        return brandToGeneric.get(brandName.trim().toLowerCase());
    }

    public static int size() {
        return brandToGeneric.size();
    }
}
