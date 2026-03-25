package org.cognizant.disastermanagement.controller;

import jakarta.validation.Valid;
import org.cognizant.disastermanagement.dto.request.IncidentRequestDTO;
import org.cognizant.disastermanagement.dto.request.AssignOfficerRequestDTO;
import org.cognizant.disastermanagement.dto.request.IncidentStatusUpdateRequestDTO;
import org.cognizant.disastermanagement.dto.response.IncidentResponseDTO;
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

    // CREATE INCIDENT
    @PostMapping
    public IncidentResponseDTO createIncident(@RequestBody IncidentRequestDTO requestDTO) {
        return service.createIncident(requestDTO);
    }

    // GET ALL INCIDENTS
    @GetMapping
    public List<IncidentResponseDTO> getAllIncidents() {
        return service.getAllIncidents();
    }

    // GET INCIDENT BY ID
    @GetMapping("/{id}")
    public IncidentResponseDTO getIncidentById(@PathVariable @Valid int id) {
        return service.getIncidentById(id);
    }

    // UPDATE INCIDENT STATUS
    @PutMapping("/{id}/status")
    public IncidentResponseDTO updateStatus(
            @PathVariable int id,
            @RequestBody IncidentStatusUpdateRequestDTO statusRequest) {

        return service.updateIncidentStatus(id, statusRequest.getStatus());
    }

    // ASSIGN OFFICER TO INCIDENT
    @PutMapping("/{id}/assign-officer")
    public IncidentResponseDTO assignOfficer(
            @PathVariable int id,
            @RequestBody AssignOfficerRequestDTO requestDTO) {

        return service.assignOfficer(id, requestDTO.getOfficerId());
    }
        @DeleteMapping("/{id}")
        public String deleteIncident(@PathVariable @Valid int id) {
            return service.deleteIncident(id);
        }
    }
