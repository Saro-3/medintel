package com.example.MedIntel.Util;

public class ImagePathUtil {

    private ImagePathUtil() {}

    public static String medicineImage(Long medicineId) {
        return "/images/medicines/" + medicineId + ".jpg";
    }
}
