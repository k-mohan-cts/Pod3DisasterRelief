package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.EmergencyReport;
import org.cognizant.disastermanagement.service.EmergencyReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class EmergencyReportController {

    private final EmergencyReportService service;

    public EmergencyReportController(EmergencyReportService service) {
        this.service = service;
    }

    @PostMapping
    public EmergencyReport create(@RequestBody EmergencyReport report) {
        return service.create(report);
    }

    @GetMapping
    public List<EmergencyReport> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmergencyReport getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public EmergencyReport updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}