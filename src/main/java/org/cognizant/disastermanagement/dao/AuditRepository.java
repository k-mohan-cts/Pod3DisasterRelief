package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {

    List<Audit> findByOfficerId(Integer officerId);

    List<Audit> findByDateBetween(LocalDateTime start, LocalDateTime end);

    List<Audit> findByAuditStatus(org.cognizant.disastermanagement.Enum.AuditStatus status);
}