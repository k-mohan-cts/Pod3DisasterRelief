package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.Citizen;
import org.cognizant.disastermanagement.dao.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public Citizen createCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public Citizen getCitizenById(int id) {
        return citizenRepository.findById(id).orElse(null);
    }

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    public Citizen updateCitizen(int id, Citizen citizenDetails) {
        Citizen existing = citizenRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(citizenDetails.getName());
            existing.setAddress(citizenDetails.getAddress());
            existing.setStatus(citizenDetails.getStatus());
            existing.setContactInfo(citizenDetails.getContactInfo());
            return citizenRepository.save(existing);
        }
        return null;
    }

    public void deleteCitizen(int id) {
        citizenRepository.deleteById(id);
    }
}