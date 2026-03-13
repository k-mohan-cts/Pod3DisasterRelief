package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.EmergencyReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyReportRequest extends JpaRepository<EmergencyReport,Integer> {

}
