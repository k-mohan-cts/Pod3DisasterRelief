package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.CitizenRepository;
import org.cognizant.disastermanagement.dao.EmergencyRepository;
import org.cognizant.disastermanagement.dto.request.EmergencyReportRequestDTO;
import org.cognizant.disastermanagement.dto.response.EmergencyReportResponseDTO;
import org.cognizant.disastermanagement.dto.response.EmergencyReportDetailsResponseDTO;
import org.cognizant.disastermanagement.entity.Citizen;
import org.cognizant.disastermanagement.entity.EmergencyReport;
import org.cognizant.disastermanagement.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmergencyReportService {

    private final EmergencyRepository reportRepo;
    private final CitizenRepository citizenRepo;

    public EmergencyReportService(EmergencyRepository reportRepo, CitizenRepository citizenRepo) {
        this.reportRepo = reportRepo;
        this.citizenRepo = citizenRepo;
    }

    // CREATE
    public EmergencyReportResponseDTO createReport(EmergencyReportRequestDTO req) {

        Citizen citizen = citizenRepo.findById(req.getCitizenId())
                .orElseThrow(() -> new ResourceNotFoundException("Citizen not found with ID: " + req.getCitizenId()));

        EmergencyReport report = new EmergencyReport();
        report.setCitizen(citizen);
        report.setLocation(req.getLocation());
        report.setType(req.getType());
        report.setStatus(req.getStatus());
        report.setLatitude(req.getLatitude());
        report.setLongitude(req.getLongitude());
        report.setDescription(req.getDescription());

        EmergencyReport saved = reportRepo.save(report);

        return toResponseDTO(saved);
    }

    // GET ALL
    public List<EmergencyReportResponseDTO> getAllReports() {
        return reportRepo.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public EmergencyReportResponseDTO getReportById(int id) {
        EmergencyReport report = reportRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with ID: " + id));
        return toResponseDTO(report);
    }

    // GET WITH CITIZEN DETAILS
    public EmergencyReportDetailsResponseDTO getReportWithCitizen(int id) {

        EmergencyReport report = reportRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with ID: " + id));

        EmergencyReportDetailsResponseDTO details = new EmergencyReportDetailsResponseDTO();
        details.setReport(toResponseDTO(report));
        details.setCitizenName(report.getCitizen().getName());
        details.setCitizenAddress(report.getCitizen().getAddress());

        return details;
    }

    // DELETE
    public String deleteReport(int id) {

        EmergencyReport report = reportRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with ID: " + id));

        reportRepo.delete(report);
        return "Emergency Report deleted successfully with ID: " + id;
    }

    // ENTITY → RESPONSE DTO
    private EmergencyReportResponseDTO toResponseDTO(EmergencyReport entity) {

        EmergencyReportResponseDTO dto = new EmergencyReportResponseDTO();

        dto.setReportId(entity.getReportId());
        dto.setCitizenId(entity.getCitizen().getCitizenId());
        dto.setLocation(entity.getLocation());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setDate(entity.getDate());

        dto.setLatitude(entity.getLatitude());
        dto.setLongitude(entity.getLongitude());
        dto.setDescription(entity.getDescription());

        return dto;
    }
}