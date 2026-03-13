package org.cognizant.disastermanagement.service; // Or your service package

import org.cognizant.disastermanagement.dao.ShelterRepository;
import org.cognizant.disastermanagement.entities.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShelterService {

    @Autowired
    private ShelterRepository shelterRepository;

    // Save a new shelter
    public Shelter addShelter(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    // Get all shelters
    public List<Shelter> getAllShelters() {
        return shelterRepository.findAll();
    }
}