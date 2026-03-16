package org.cognizant.disastermanagement.controller;

import org.cognizant.disastermanagement.entity.Incident;
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
    public Incident create(@RequestBody Incident incident) {
        return service.create(incident);
    }

    @GetMapping
    public List<Incident> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Incident getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public Incident updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}