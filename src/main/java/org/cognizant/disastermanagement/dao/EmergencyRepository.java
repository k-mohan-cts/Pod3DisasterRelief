package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.EmergencyReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository extends JpaRepository<EmergencyReport, Integer> {
}