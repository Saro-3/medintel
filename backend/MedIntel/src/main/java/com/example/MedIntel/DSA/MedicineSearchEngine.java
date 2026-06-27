package com.example.MedIntel.DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedicineSearchEngine {

    // Sorted list of medicine names (lowercase)
    private static final List<String> sortedNames = new ArrayList<>();

    private MedicineSearchEngine() {
    }

    // Load data once (Called from initializer)
    public static void loadNames(List<String> names) {
        sortedNames.clear();
        for (String name : names) {
            if (name != null) {
                sortedNames.add(name.toLowerCase());
            }
        }
        Collections.sort(sortedNames); // REQUIRED for Binary Search
    }

    //Prefix search using Binary Search
    public static List<String> searchByPrefix(String prefix) {

        System.out.println("[DSA] Binary Search Prefix lookup started");

        List<String> result = new ArrayList<>();

        if (prefix == null || prefix.isBlank()) {
            System.out.println("[DSA] Empty prefix received");
            return result;
        }

        prefix = prefix.toLowerCase();
        System.out.println("[DSA] Searching for prefix: " + prefix);

        int left = 0;
        int right = sortedNames.size() - 1;

        // Find first possible match
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midVal = sortedNames.get(mid);

            if (midVal.startsWith(prefix)) {

                System.out.println("[DSA] Match found at index: " + mid);
                // Expand around mid
                int i = mid;
                while (i >= 0 && sortedNames.get(i).startsWith(prefix)) {
                    result.add(sortedNames.get(i));
                    i--;
                }
                i = mid + 1;
                while (i < sortedNames.size() && sortedNames.get(i).startsWith(prefix)) {
                    result.add(sortedNames.get(i));
                    i++;
                }
                break;
            }

            if (midVal.compareTo(prefix) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("📦 [DSA] Results: " + result);
        System.out.println("❌ [DB] Database NOT accessed (DSA only)");

        return result;
    }
}
