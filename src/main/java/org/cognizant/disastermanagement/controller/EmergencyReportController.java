package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.EmergencyReportRequestDTO;
import org.cognizant.disastermanagement.dto.EmergencyReportResponseDTO;
import org.cognizant.disastermanagement.dto.EmergencyReportWithCitizenResponseDTO;
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
    public EmergencyReportResponseDTO createReport(@RequestBody EmergencyReportRequestDTO request) {
        return service.create(request);
    }

    @GetMapping
    public List<EmergencyReportResponseDTO> getAllReports() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EmergencyReportResponseDTO getReportById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/{id}/details")
    public EmergencyReportWithCitizenResponseDTO getReportWithCitizen(@PathVariable Long id) {
        return service.getReportWithCitizen(id);
    }
}