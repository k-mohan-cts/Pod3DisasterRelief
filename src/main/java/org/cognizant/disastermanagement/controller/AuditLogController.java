package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.AuditLog;
import org.cognizant.disastermanagement.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping("/GetAllLogs")
    public List<AuditLog> getAllLogs() {
        return auditLogService.getAllLogs();
    }

    @PostMapping("/CreateLog")
    public AuditLog createLog(@RequestBody AuditLog log) {
        return auditLogService.logAction(log);
    }
}