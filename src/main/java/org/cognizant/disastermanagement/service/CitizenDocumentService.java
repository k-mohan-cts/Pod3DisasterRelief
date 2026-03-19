package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.Citizen;
import org.cognizant.disastermanagement.entity.CitizenDocument;
import org.cognizant.disastermanagement.dao.CitizenDocumentRepository;
import org.cognizant.disastermanagement.dao.CitizenRepository;
import org.springframework.stereotype.Service;

@Service
public class CitizenDocumentService {

    private final CitizenDocumentRepository documentRepo;
    private final CitizenRepository citizenRepository;

    public CitizenDocumentService(
            CitizenDocumentRepository documentRepo,
            CitizenRepository citizenRepository) {
        this.documentRepo = documentRepo;
        this.citizenRepository = citizenRepository;
    }

    public CitizenDocument uploadDocument(CitizenDocument doc) {

        // ✅ LOAD managed Citizen from DB (CRITICAL FIX)
        int citizenId = doc.getCitizen().getCitizenId();
        Citizen citizen = citizenRepository.findById(citizenId)
                .orElseThrow(() -> new RuntimeException("Citizen not found"));

        doc.setCitizen(citizen);

        return documentRepo.save(doc);
    }

    public CitizenDocument getDocumentById(int docId) {
        return documentRepo.findById(docId)
                .orElseThrow(() -> new RuntimeException("CitizenDocument not found"));
    }

    public void deleteDocument(int docId) {
        documentRepo.deleteById(docId);
    }
}