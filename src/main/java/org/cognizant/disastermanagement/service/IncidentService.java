package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.Enum.IncidentStatus;
import org.cognizant.disastermanagement.dao.IncidentRepository;
import org.cognizant.disastermanagement.dto.AssignOfficerRequestDTO;
import org.cognizant.disastermanagement.dto.CreateIncidentRequestDTO;
import org.cognizant.disastermanagement.dto.IncidentResponseDTO;
import org.cognizant.disastermanagement.entity.Incident;
import org.cognizant.disastermanagement.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentService {

    private final IncidentRepository repository;

    public IncidentService(IncidentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public IncidentResponseDTO create(CreateIncidentRequestDTO req) {

        Incident incident = new Incident();
        incident.setReportId(req.getReportId());
        incident.setOfficerId(req.getOfficerId());
        incident.setActions(req.getActions());
        incident.setStatus(IncidentStatus.ACKNOWLEDGED);

        return toDTO(repository.save(incident));
    }

    // GET ALL
    public List<IncidentResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // GET ONE
    public IncidentResponseDTO getById(Long id) {
        Incident incident = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found"));
        return toDTO(incident);
    }

    // UPDATE STATUS
    public IncidentResponseDTO updateStatus(Long id, String status) {

        Incident incident = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found"));

        incident.setStatus(IncidentStatus.valueOf(status.toUpperCase()));

        return toDTO(repository.save(incident));
    }

    // ASSIGN OFFICER
    public IncidentResponseDTO assignReliefOfficer(Long id, AssignOfficerRequestDTO req) {

        Incident incident = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found"));

        incident.setOfficerId(req.getOfficerId());
        incident.setStatus(IncidentStatus.ACKNOWLEDGED);

        return toDTO(repository.save(incident));
    }

    // MAPPER
    private IncidentResponseDTO toDTO(Incident incident) {
        IncidentResponseDTO dto = new IncidentResponseDTO();
        dto.setIncidentId(incident.getIncidentId());
        dto.setReportId(incident.getReportId());
        dto.setOfficerId(incident.getOfficerId());
        dto.setActions(incident.getActions());
        dto.setDate(incident.getDate());
        dto.setStatus(incident.getStatus());
        return dto;
    }
}