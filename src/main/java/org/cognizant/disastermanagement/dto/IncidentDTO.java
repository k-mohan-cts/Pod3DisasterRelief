package org.cognizant.disastermanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import org.cognizant.disastermanagement.Enum.IncidentStatus;

import java.time.LocalDateTime;

public class IncidentDTO {

    private int incidentId;

    @NotNull(message = "Report ID is required")
    private int reportId;   // EmergencyReport reference by ID

    @NotNull(message = "Officer ID is required")
    private int officerId;  // User reference by ID (Role = OFFICER)

    @NotBlank(message = "Actions are required")
    private String actions;

    private LocalDateTime date;

    private IncidentStatus status;

    // --- GETTERS & SETTERS ---

    public Integer getIncidentId() { return incidentId; }
    public void setIncidentId(int incidentId) { this.incidentId = incidentId; }

    public int getReportId() { return reportId; }
    public void setReportId(int reportId) { this.reportId = reportId; }

    public int getOfficerId() { return officerId; }
    public void setOfficerId(int officerId) { this.officerId = officerId; }

    public String getActions() { return actions; }
    public void setActions(String actions) { this.actions = actions; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public IncidentStatus getStatus() { return status; }
    public void setStatus(IncidentStatus status) { this.status = status; }
}