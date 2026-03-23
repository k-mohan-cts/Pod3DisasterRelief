package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.AuditLog;
import org.cognizant.disastermanagement.dao.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditRepo;

    public AuditLog logAction(AuditLog log) {
        return auditRepo.save(log);
    }

    public List<AuditLog> getAllLogs() {
        return auditRepo.findAll();
    }
}