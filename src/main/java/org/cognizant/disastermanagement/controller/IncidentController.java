package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dto.IncidentDTO;
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

    // CREATE an incident
    @PostMapping
    public IncidentDTO createIncident(@RequestBody IncidentDTO dto) {
        return service.create(dto);
    }

    // GET all incidents
    @GetMapping
    public List<IncidentDTO> getAllIncidents() {
        return service.getAll();
    }

    // GET a single incident
    @GetMapping("/{id}")
    public IncidentDTO getIncidentById(@PathVariable int id) {
        return service.getById(id);
    }

    // UPDATE incident status
    @PutMapping("/{id}/status")
    public IncidentDTO updateIncidentStatus(
            @PathVariable int id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    // ASSIGN relief officer to an incident
    @PutMapping("/{id}/assign-officer/{officerId}")
    public IncidentDTO assignOfficer(
            @PathVariable int id,
            @PathVariable int officerId) {
        return service.assignOfficer(id, officerId);
    }
}