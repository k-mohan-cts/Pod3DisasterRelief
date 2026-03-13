package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.dao.IncidentRequest ;
import org.cognizant.disastermanagement.dao.IncidentResponse;
import org.cognizant.disastermanagement.service.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    // CREATE INCIDENT
    @PostMapping
    public ResponseEntity<IncidentResponse> createIncident(@RequestBody IncidentRequest request) {
        return ResponseEntity.ok(incidentService.createIncident(request));
    }

    // GET ALL INCIDENTS
    @GetMapping
    public ResponseEntity<List<IncidentResponse>> getAllIncidents() {
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }

    // GET BY ID
    @GetMapping("/{incidentId}")
    public ResponseEntity<IncidentResponse> getById(@PathVariable Integer incidentId) {
        return ResponseEntity.ok(incidentService.getIncidentById(incidentId));
    }

    // UPDATE INCIDENT STATUS
    @PutMapping("/{incidentId}/status")
    public ResponseEntity<IncidentResponse> updateStatus(
            @PathVariable Integer incidentId,
            @RequestParam String status,
            @RequestParam(required = false) String notes
    ) {
        return ResponseEntity.ok(incidentService.updateStatus(incidentId, status, notes));
    }
}