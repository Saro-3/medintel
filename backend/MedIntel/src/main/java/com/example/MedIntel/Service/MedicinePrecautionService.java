package com.example.MedIntel.Service;
import com.example.MedIntel.Model.MedicinePrecaution;

import java.util.List;

public interface MedicinePrecautionService {

    List<MedicinePrecaution> getPrecautionsById(Long id);

}
