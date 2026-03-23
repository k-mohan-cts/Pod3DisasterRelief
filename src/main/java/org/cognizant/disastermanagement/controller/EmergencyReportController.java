package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.EmergencyReportDTO;
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
    public EmergencyReportDTO createReport(@RequestBody EmergencyReportDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<EmergencyReportDTO> getAllReports() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmergencyReportDTO getReportById(@PathVariable int id) {
        return service.getById(id);
    }

    // Endpoint that triggers the getWithCitizen method
    @GetMapping("/{id}/details")
    public EmergencyReportDTO getReportWithCitizen(@PathVariable int id) {
        return service.getWithCitizen(id);
    }
}