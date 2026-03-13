package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.entity.Resource;
import org.cognizant.disastermanagement.Enum.ResourceStatus;
import java.util.List;

public interface ResourceService {
    Resource addResource(int programId, Resource resource);
    List<Resource> getAllResources();
    List<Resource> getResourcesByProgram(int programId);
    Resource updateResourceStatus(int resourceId, ResourceStatus status);
    void deleteResource(int resourceId);
}