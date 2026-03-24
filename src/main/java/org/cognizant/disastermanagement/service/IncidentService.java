package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.EmergencyRepository;
import org.cognizant.disastermanagement.dao.IncidentRepository;
import org.cognizant.disastermanagement.dao.UserRepository;
import org.cognizant.disastermanagement.dto.request.IncidentRequestDTO;
import org.cognizant.disastermanagement.dto.request.IncidentStatusUpdateRequestDTO;
import org.cognizant.disastermanagement.dto.request.AssignOfficerRequestDTO;
import org.cognizant.disastermanagement.dto.response.IncidentResponseDTO;
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
    public IncidentResponseDTO createIncident(IncidentRequestDTO req) {

        EmergencyReport report = reportRepo.findById(req.getReportId())
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with ID: " + req.getReportId()));

        User officer = userRepo.findById(req.getOfficerId())
                .orElseThrow(() -> new ResourceNotFoundException("Officer not found with ID: " + req.getOfficerId()));

        Incident incident = new Incident();
        incident.setEmergencyReport(report);
        incident.setOfficer(officer);
        incident.setActions(req.getActions());
        incident.setStatus(req.getStatus());

        Incident saved = incidentRepo.save(incident);

        return toResponseDTO(saved);
    }

    // GET ALL INCIDENTS
    public List<IncidentResponseDTO> getAllIncidents() {
        return incidentRepo.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // GET INCIDENT BY ID
    public IncidentResponseDTO getIncidentById(int id) {
        Incident incident = incidentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with ID: " + id));
        return toResponseDTO(incident);
    }

    // UPDATE STATUS
    public IncidentResponseDTO updateIncidentStatus(int id, String status) {

        Incident incident = incidentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with ID: " + id));

        incident.setStatus(IncidentStatus.valueOf(status.toUpperCase()));

        Incident updated = incidentRepo.save(incident);
        return toResponseDTO(updated);
    }

    // ASSIGN OFFICER
    public IncidentResponseDTO assignOfficer(int id, int officerId) {

        Incident incident = incidentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with ID: " + id));

        User officer = userRepo.findById(officerId)
                .orElseThrow(() -> new ResourceNotFoundException("Officer not found with ID: " + officerId));

        incident.setOfficer(officer);

        Incident updated = incidentRepo.save(incident);
        return toResponseDTO(updated);
    }

    // DELETE INCIDENT
    public String deleteIncident(int id) {
        Incident incident = incidentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with ID: " + id));

        incidentRepo.delete(incident);
        return "Incident deleted successfully with ID: " + id;
    }

    // ENTITY → RESPONSE DTO
    private IncidentResponseDTO toResponseDTO(Incident entity) {

        IncidentResponseDTO dto = new IncidentResponseDTO();

        dto.setIncidentId(entity.getIncidentId());
        dto.setReportId(entity.getEmergencyReport().getReportId());
        dto.setOfficerId(entity.getOfficer().getUserId());
        dto.setActions(entity.getActions());
        dto.setStatus(entity.getStatus());
        dto.setDate(entity.getDate());

        return dto;
    }
}