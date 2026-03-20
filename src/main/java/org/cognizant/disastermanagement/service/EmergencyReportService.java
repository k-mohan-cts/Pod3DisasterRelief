package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.CitizenRepository;
import org.cognizant.disastermanagement.dao.EmergencyRepository;
import org.cognizant.disastermanagement.dto.EmergencyReportDTO;
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
    public EmergencyReportDTO create(EmergencyReportDTO dto) {

        Citizen citizen = citizenRepo.findById(dto.getCitizenId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Citizen not found with ID: " + dto.getCitizenId()));

        EmergencyReport report = new EmergencyReport(dto);
        report.setCitizen(citizen);

        EmergencyReport saved = reportRepo.save(report);

        return toDTO(saved);
    }

    // GET ALL
    public List<EmergencyReportDTO> getAll() {
        return reportRepo.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public EmergencyReportDTO getById(int id) {
        EmergencyReport report = reportRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Report not found with ID: " + id));
        return toDTO(report);
    }

    // GET WITH CITIZEN
    public EmergencyReportDTO getWithCitizen(int id) {
        EmergencyReport report = reportRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Report not found with ID: " + id));
        return toDTO(report);
    }

    // ENTITY → DTO
    private EmergencyReportDTO toDTO(EmergencyReport entity) {

        EmergencyReportDTO dto = new EmergencyReportDTO();

        dto.setReportId(entity.getReportId());
        dto.setLocation(entity.getLocation());
        dto.setType(entity.getType());
        dto.setStatus(entity.getStatus());
        dto.setDate(entity.getDate());

        if (entity.getCitizen() != null) {
            dto.setCitizenId(entity.getCitizen().getCitizenId());
        }

        return dto;
    }
}