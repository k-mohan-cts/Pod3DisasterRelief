package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.Enum.ReportStatus;
import org.cognizant.disastermanagement.dao.CitizenRepository;
import org.cognizant.disastermanagement.dao.EmergencyRepository;
import org.cognizant.disastermanagement.dto.EmergencyReportRequestDTO;
import org.cognizant.disastermanagement.dto.EmergencyReportResponseDTO;
import org.cognizant.disastermanagement.dto.EmergencyReportWithCitizenResponseDTO;
import org.cognizant.disastermanagement.entity.Citizen;
import org.cognizant.disastermanagement.entity.EmergencyReport;
import org.cognizant.disastermanagement.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmergencyReportService {

    private final EmergencyRepository reportRepo;
    //private final CitizenRepository citizenRepo;
    private final int citizenRepo;

    public EmergencyReportService(EmergencyRepository reportRepo, int citizenRepo) {
        this.reportRepo = reportRepo;
        this.citizenRepo = citizenRepo;
    }

    // CREATE
    public EmergencyReportResponseDTO create(EmergencyReportRequestDTO req) {

        citizenRepo.findById(req.getCitizenId())
                .orElseThrow(() -> new ResourceNotFoundException("Citizen not found"));

        EmergencyReport report = new EmergencyReport();
        report.setCitizenId(req.getCitizenId());
        report.setType(req.getType());
        report.setLocation(req.getLocation());
        report.setStatus(ReportStatus.PENDING);

        EmergencyReport saved = reportRepo.save(report);
        return toDTO(saved);
    }

    // GET ALL
    public List<EmergencyReportResponseDTO> getAll() {
        return reportRepo.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // GET ONE
    public EmergencyReportResponseDTO getById(Long id) {
        EmergencyReport report = reportRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));
        return toDTO(report);
    }

    // GET ONE WITH CITIZEN
    public EmergencyReportWithCitizenResponseDTO getReportWithCitizen(Long id) {

        EmergencyReport report = reportRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));

        Citizen citizen = citizenRepo.findById(report.getCitizenId())
                .orElseThrow(() -> new ResourceNotFoundException("Citizen not found"));

        EmergencyReportWithCitizenResponseDTO dto = new EmergencyReportWithCitizenResponseDTO();
        dto.setReport(toDTO(report));
        dto.setCitizen(citizen);

        return dto;
    }

    // MAPPER
    private EmergencyReportResponseDTO toDTO(EmergencyReport report) {
        EmergencyReportResponseDTO dto = new EmergencyReportResponseDTO();
        dto.setReportId(report.getReportId());
        dto.setCitizenId(report.getCitizenId());
        dto.setType(report.getType());
        dto.setLocation(report.getLocation());
        dto.setDate(report.getDate());
        dto.setStatus(report.getStatus());
        return dto;
    }
}