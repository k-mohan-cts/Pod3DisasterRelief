package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.*;
import org.cognizant.disastermanagement.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitizenManagementService {
    @Autowired private CitizenRepository citizenRepository;
    @Autowired private CitizenDocumentRepository documentRepository;

    public Citizen registerCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public CitizenDocument uploadDocument(CitizenDocument doc) {
        return documentRepository.save(doc);
    }

    public List<Citizen> getPendingVerifications() {
        // Simple logic: find by status
        return citizenRepository.findAll().stream()
                .filter(c -> "Pending".equals(c.getStatus()))
                .toList();
    }
}