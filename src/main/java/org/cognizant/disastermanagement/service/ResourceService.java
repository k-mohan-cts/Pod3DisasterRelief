package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.RecoveryProgram;
import org.cognizant.disastermanagement.entity.Resource;
import org.cognizant.disastermanagement.Enum.ResourceStatus;
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
    public Resource addResource(int programId, Resource resource) {
        RecoveryProgram program = programRepo.findById(programId)
                .orElseThrow(() -> new RuntimeException("Program not found: " + programId));
        resource.setRecoveryProgram(program);
        return resourceRepo.save(resource);
    }

    public List<Resource> getAllResources() {
        return resourceRepo.findAll();
    }

    public List<Resource> getResourcesByProgram(int programId) {
        return resourceRepo.findByRecoveryProgramProgramId(programId);
    }

    @Transactional
    public Resource updateResourceStatus(int resourceId, ResourceStatus status) {
        Resource resource = resourceRepo.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found: " + resourceId));
        resource.setStatus(status);
        return resourceRepo.save(resource);
    }

    @Transactional
    public void deleteResource(int resourceId) {
        resourceRepo.deleteById(resourceId);
    }
}