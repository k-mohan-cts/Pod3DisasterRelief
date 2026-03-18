package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.RecoveryProgram;
import org.cognizant.disastermanagement.entity.Resource;
import org.cognizant.disastermanagement.dao.RecoveryProgramRepository;
import org.cognizant.disastermanagement.dao.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepo;

    @Autowired
    private RecoveryProgramRepository programRepo;

    @Transactional
    public void addResource(int programId, Resource resource) {
        RecoveryProgram program = programRepo.findById(programId)
                .orElseThrow(() -> new RuntimeException("Program not found with ID: " + programId));
        resource.setRecoveryProgram(program);
        resourceRepo.save(resource);
    }

    public List<Resource> getAllResources() {
        return resourceRepo.findAll();
    }
}