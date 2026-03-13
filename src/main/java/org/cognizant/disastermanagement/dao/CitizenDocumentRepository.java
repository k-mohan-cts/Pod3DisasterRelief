package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.CitizenDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CitizenDocumentRepository extends JpaRepository<CitizenDocument, Integer> {
    // Retrieve all documents belonging to a specific citizen
    List<CitizenDocument> findByCitizen_CitizenId(int citizenId);

    // Find documents that need verification
    List<CitizenDocument> findByVerificationStatus(String status);
}