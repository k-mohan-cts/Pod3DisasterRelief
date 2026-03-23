package org.cognizant.disastermanagement.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.ReportStatus;

import java.time.LocalDateTime;

public class EmergencyReportDTO {

    private Integer reportId;

    @NotNull(message = "Citizen ID is required")
    private Integer citizenId;

    @NotNull(message = "Emergency type is required")
    private EmergencyType type;

    @NotBlank(message = "Location is required")
    private String location;

    private LocalDateTime date;

    private ReportStatus status;

    // --- GETTERS AND SETTERS ---

    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }

    public Integer getCitizenId() { return citizenId; }
    public void setCitizenId(Integer citizenId) { this.citizenId = citizenId; }

    public EmergencyType getType() { return type; }
    public void setType(EmergencyType type) { this.type = type; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public ReportStatus getStatus() { return status; }
    public void setStatus(ReportStatus status) { this.status = status; }
}