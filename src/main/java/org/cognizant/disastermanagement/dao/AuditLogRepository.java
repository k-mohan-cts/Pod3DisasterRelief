package org.cognizant.disastermanagement.dao;

import org.cognizant.disastermanagement.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
    // Useful for viewing history for a specific user
    List<AuditLog> findByUser_UserId(int userId);
}