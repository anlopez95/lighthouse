package com.meli.lighthouse.store;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.meli.lighthouse.model.SatelitesDTO;

@Component
public class SateliteDataStore {
    private final Map<String, SatelitesDTO> satellites = new HashMap<>();

    public void updateSatelliteData(String name, SatelitesDTO satelite) {
        satellites.put(name, satelite);
    }

    public Collection<SatelitesDTO> getAllSatellites() {
        return satellites.values();
    }

    public SatelitesDTO getSatellite(String name) {
        return satellites.get(name);
    }
    
}
    
