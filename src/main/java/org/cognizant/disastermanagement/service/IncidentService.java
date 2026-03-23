package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.EmergencyRepository;
import org.cognizant.disastermanagement.dao.IncidentRepository;
import org.cognizant.disastermanagement.dao.UserRepository;
import org.cognizant.disastermanagement.dto.IncidentDTO;
import org.cognizant.disastermanagement.entity.EmergencyReport;
import org.cognizant.disastermanagement.entity.Incident;
import org.cognizant.disastermanagement.entity.User;
import org.cognizant.disastermanagement.Enum.IncidentStatus;
import org.cognizant.disastermanagement.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepo;
    private final EmergencyRepository reportRepo;
    private final UserRepository userRepo;

    public IncidentService(IncidentRepository incidentRepo,
                           EmergencyRepository reportRepo,
                           UserRepository userRepo) {
        this.incidentRepo = incidentRepo;
        this.reportRepo = reportRepo;
        this.userRepo = userRepo;
    }

    // CREATE INCIDENT
    public IncidentDTO create(IncidentDTO dto) {

        EmergencyReport report = reportRepo.findById(dto.getReportId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Report not found with ID: " + dto.getReportId()));

        User officer = userRepo.findById(dto.getOfficerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Officer not found with ID: " + dto.getOfficerId()));

        Incident incident = new Incident(dto);
        incident.setEmergencyReport(report);
        incident.setOfficer(officer);

        Incident saved = incidentRepo.save(incident);

        return toDTO(saved);
    }

    // GET ALL INCIDENTS
    public List<IncidentDTO> getAll() {
        return incidentRepo.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public IncidentDTO getById(int id) {
        Incident incident = incidentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Incident not found with ID: " + id));
        return toDTO(incident);
    }

    // UPDATE STATUS
    public IncidentDTO updateStatus(int id, String status) {

        Incident incident = incidentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Incident not found with ID: " + id));

        incident.setStatus(IncidentStatus.valueOf(status.toUpperCase()));

        Incident updated = incidentRepo.save(incident);

        return toDTO(updated);
    }

    // ASSIGN OFFICER
    public IncidentDTO assignOfficer(int id, int officerId) {

        Incident incident = incidentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Incident not found with ID: " + id));

        User officer = userRepo.findById(officerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Officer not found with ID: " + officerId));

        incident.setOfficer(officer);

        Incident updated = incidentRepo.save(incident);

        return toDTO(updated);
    }

    // ENTITY → DTO
    private IncidentDTO toDTO(Incident entity) {

        IncidentDTO dto = new IncidentDTO();

        dto.setIncidentId(entity.getIncidentId());
        dto.setActions(entity.getActions());
        dto.setDate(entity.getDate());
        dto.setStatus(entity.getStatus());

        if (entity.getEmergencyReport() != null) {
            dto.setReportId(entity.getEmergencyReport().getReportId());
        }

        if (entity.getOfficer() != null) {
            dto.setOfficerId(entity.getOfficer().getUserId());
        }

        return dto;
    }
}