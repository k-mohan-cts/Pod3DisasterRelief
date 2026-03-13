package org.cognizant.disastermanagement.service;

import org.cognizant.disastermanagement.dao.IncidentRequest;
import org.cognizant.disastermanagement.dao.IncidentResponse;

import java.util.List;

public interface IncidentService {

    IncidentResponse createIncident(IncidentRequest request);

    List<IncidentResponse> getAllIncidents();

    IncidentResponse getIncidentById(Integer incidentId);

    IncidentResponse updateStatus(Integer incidentId, String status, String notes);
}