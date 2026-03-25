package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.EmergencyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyRepository extends JpaRepository<EmergencyReport, Integer> {
}