package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.IncidentRepository;
import org.cognizant.disastermanagement.entity.Incident;
import org.cognizant.disastermanagement.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository repository;

    public IncidentService(IncidentRepository repository) {
        this.repository = repository;
    }

    public Incident create(Incident incident) {
        incident.setStatus("Acknowledged");
        return repository.save(incident);
    }

    public List<Incident> getAll() {
        return repository.findAll();
    }

    public Incident getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found: " + id));
    }

    public Incident updateStatus(Long id, String status) {
        Incident incident = getById(id);
        incident.setStatus(status);
        return repository.save(incident);
    }
}