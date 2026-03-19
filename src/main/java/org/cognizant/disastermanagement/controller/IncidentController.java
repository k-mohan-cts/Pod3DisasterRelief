package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.AssignOfficerRequestDTO;
import org.cognizant.disastermanagement.dto.CreateIncidentRequestDTO;
import org.cognizant.disastermanagement.dto.IncidentResponseDTO;
import org.cognizant.disastermanagement.dto.IncidentResponseDTO;
import org.cognizant.disastermanagement.dto.CreateIncidentRequestDTO;
import org.cognizant.disastermanagement.dto.IncidentResponseDTO;
import org.cognizant.disastermanagement.service.IncidentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService service;

    public IncidentController(IncidentService service) {
        this.service = service;
    }

    @PostMapping
    public IncidentResponseDTO createIncident(@RequestBody CreateIncidentRequestDTO request) {
        return service.create(request);
    }

    @GetMapping
    public List<IncidentResponseDTO> getAllIncidents() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public IncidentResponseDTO getIncidentById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public IncidentResponseDTO updateIncidentStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @PutMapping("/{incidentId}/assign-officer")
    public IncidentResponseDTO assignReliefOfficer(
            @PathVariable Long incidentId,
            @RequestBody AssignOfficerRequestDTO request) {
        return service.assignReliefOfficer(incidentId, request);
    }
}