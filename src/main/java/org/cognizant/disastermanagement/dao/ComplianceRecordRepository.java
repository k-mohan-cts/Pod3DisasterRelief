package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.ComplianceRecord;
import org.cognizant.disastermanagement.entity.User;
import org.cognizant.disastermanagement.Enum.ComplianceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplianceRecordRepository extends JpaRepository<ComplianceRecord, Integer> {
    List<ComplianceRecord> findByOfficer(User officer);
    List<ComplianceRecord> findByResult(ComplianceResult result);
    List<ComplianceRecord> findByEntityId(Integer entityId);
}