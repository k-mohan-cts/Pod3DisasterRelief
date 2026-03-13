package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dao.EmergencyReportRequest ;
import org.cognizant.disastermanagement.dao.EmergencyReportResponse ;
import org.cognizant.disastermanagement.service.EmergencyReportService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class EmergencyReportController {

    private final EmergencyReportService emergencyReportService;

    public EmergencyReportController(EmergencyReportService emergencyReportService) {
        this.emergencyReportService = emergencyReportService;
    }

    // CREATE REPORT
    @PostMapping
    public ResponseEntity<EmergencyReportResponse> createReport(@RequestBody EmergencyReportRequest request) {
        EmergencyReportResponse response = emergencyReportService.createReport(request);
        return ResponseEntity.ok(response);
    }

    // GET ALL REPORTS
    @GetMapping
    public ResponseEntity<List<EmergencyReportResponse>> getAllReports() {
        return ResponseEntity.ok(emergencyReportService.getAllReports());
    }

    // GET REPORT BY ID
    @GetMapping("/{reportId}")
    public ResponseEntity<EmergencyReportResponse> getById(@PathVariable Integer reportId) {
        return ResponseEntity.ok(emergencyReportService.getReportById(reportId));
    }

    // UPDATE STATUS
    @PutMapping("/{reportId}/status")
    public ResponseEntity<EmergencyReportResponse> updateStatus(
            @PathVariable Integer reportId,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(emergencyReportService.updateStatus(reportId, status));
    }
}