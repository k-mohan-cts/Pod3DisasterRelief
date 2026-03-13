package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.ComplianceRecordRepository;
import org.cognizant.disastermanagement.entity.ComplianceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceRecordService {

    @Autowired
    private ComplianceRecordRepository complianceRecordRepository;

    public ComplianceRecord create(ComplianceRecord record) {
        return complianceRecordRepository.save(record);
    }

    public ComplianceRecord getById(Integer id) {
        return complianceRecordRepository.findById(id).orElse(null);
    }

    public List<ComplianceRecord> getAll() {
        return complianceRecordRepository.findAll();
    }

    public List<ComplianceRecord> getByOfficer(Integer officerId) {
        return complianceRecordRepository.findByOfficerId(officerId);
    }

    public ComplianceRecord update(Integer id, ComplianceRecord updated) {
        return complianceRecordRepository.findById(id).map(record -> {

            record.setNotes(updated.getNotes());
            record.setOfficerId(updated.getOfficerId());
            return complianceRecordRepository.save(record);
        }).orElse(null);
    }

    public void delete(Integer id) {
        complianceRecordRepository.deleteById(id);
    }
}