package org.cognizant.disastermanagement.dao;

public interface IncidentRequest {
    Integer getReportId();
    Integer getOfficerId();
    String getActions();
}