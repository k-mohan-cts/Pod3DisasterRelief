package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.AuditRepository;
import org.cognizant.disastermanagement.entity.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public Audit create(Audit audit) {
        return auditRepository.save(audit);
    }

    public Audit getById(Integer id) {
        return auditRepository.findById(id).orElse(null);
    }

    public List<Audit> getAll() {
        return auditRepository.findAll();
    }

    public Audit update(Integer id, Audit updated) {
        return auditRepository.findById(id).map(audit -> {
            audit.setScope(updated.getScope());
            audit.setFindings(updated.getFindings());

            return auditRepository.save(audit);
        }).orElse(null);
    }

    public void delete(Integer id) {
        auditRepository.deleteById(id);
    }

    public List<Audit> getCreatedBetween(LocalDateTime start, LocalDateTime end) {
        return auditRepository.findByDateBetween(start, end);
    }
}