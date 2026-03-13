package org.cognizant.disastermanagement.dao;

import java.time.LocalDateTime;

public interface IncidentResponse {
    Integer getIncidentId();
    Integer getReportId();
    Integer getOfficerId();
    String getActions();
    String getStatus();
    String getNotes();
    LocalDateTime getDate();
    LocalDateTime getUpdatedAt();
}