package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.CitizenDocument;
import org.cognizant.disastermanagement.dao.CitizenDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenDocumentService {

    @Autowired
    private CitizenDocumentRepository documentRepo;

    public CitizenDocument uploadDocument(CitizenDocument doc) {
        return documentRepo.save(doc);
    }

    public CitizenDocument getDocumentById(int docId) {
        return documentRepo.findById(docId).orElse(null);
    }

    public void deleteDocument(int docId) {
        documentRepo.deleteById(docId);
    }
}