package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}