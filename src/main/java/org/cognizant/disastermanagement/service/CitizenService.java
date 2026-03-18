package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.Citizen;
import org.cognizant.disastermanagement.dao.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public Citizen createCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public Citizen getCitizenById(int citizenId) {
        return citizenRepository.findById(citizenId).orElse(null);
    }

    public Citizen updateCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public void deleteCitizen(int citizenId) {
        citizenRepository.deleteById(citizenId);
    }
}