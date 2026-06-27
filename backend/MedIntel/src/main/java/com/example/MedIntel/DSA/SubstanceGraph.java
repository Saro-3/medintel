package com.example.MedIntel.DSA;

import java.util.*;

public class SubstanceGraph {

    // Key -> Substance (API name)
    // Value -> list of medicine names
    private static final Map<String, List<String>> graph = new HashMap<>();

    private SubstanceGraph() {}

    // Add edge: substance -> medicine
    public static void addRelation(String substance, String medicineName) {

        if (substance == null || medicineName == null) {
            return;
        }

        substance = substance.trim().toLowerCase();
        medicineName = medicineName.trim();

        graph.computeIfAbsent(substance, k -> new ArrayList<>())
                .add(medicineName);
    }

    // DFS-like lookup (simple adjacency list traversal)
    public static List<String> getMedicinesBySubstance(String substance) {

        if (substance == null) {
            return Collections.emptyList();
        }

        substance = substance.trim().toLowerCase();

        System.out.println("[GRAPH] Searching medicines for substance: " + substance);

        List<String> medicines = graph.get(substance);

        if (medicines == null) {
            System.out.println("[GRAPH] No medicine found for substance: " + substance);
            return Collections.emptyList();
        }

        System.out.println("[GRAPH] Found medicine: " + medicines);
        System.out.println("[DB] Database NOT accessed (Graph only)");

        return medicines;
    }

    //Debug helper
    public static int size() {
        return graph.size();
    }
}
