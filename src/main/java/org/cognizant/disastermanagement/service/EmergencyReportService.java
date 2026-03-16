package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.EmergencyRepository;
import org.cognizant.disastermanagement.entity.EmergencyReport;
import org.cognizant.disastermanagement.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmergencyReportService {

    private final EmergencyRepository repository;

    public EmergencyReportService(EmergencyRepository repository) {
        this.repository = repository;
    }

    public EmergencyReport create(EmergencyReport report) {
        report.setStatus("Pending");
        return repository.save(report);
    }

    public List<EmergencyReport> getAll() {
        return repository.findAll();
    }

    public EmergencyReport getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency Report not found: " + id));
    }

    public EmergencyReport updateStatus(Long id, String status) {
        EmergencyReport report = getById(id);
        report.setStatus(status);
        return repository.save(report);
    }
}