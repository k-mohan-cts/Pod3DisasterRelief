package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.CitizenDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenDocumentRepository extends JpaRepository<CitizenDocument, Integer> {
}
