package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.request.AuditLogRequestDTO;
import org.cognizant.disastermanagement.entity.AuditLog;
import org.cognizant.disastermanagement.entity.User;
import org.cognizant.disastermanagement.service.AuditLogService;
import org.cognizant.disastermanagement.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @Autowired
    private UserService userService;

    // ✅ GET ALL LOGS
    @GetMapping("/GetAllLogs")
    public List<AuditLog> getAllLogs() {
        return auditLogService.getAllLogs();
    }

    // ✅ CREATE LOG WITH VALIDATION
    @PostMapping("/CreateLog")
    public AuditLog createLog(
            @Valid @RequestBody AuditLogRequestDTO requestDTO) {

        // Load User using userId from DTO
        User user = userService.getUserById(requestDTO.getUserId());

        // Map DTO → Entity
        AuditLog log = new AuditLog();
        log.setUser(user);
        log.setAction(requestDTO.getAction());
        log.setResource(requestDTO.getResource());
        log.setTimestamp(requestDTO.getTimestamp());
        log.setIpAddress(requestDTO.getIpAddress());
        log.setDetails(requestDTO.getDetails());

        // Save using service
        return auditLogService.logAction(log);
    }
}