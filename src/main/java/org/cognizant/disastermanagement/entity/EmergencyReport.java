package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.ReportStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "EmergencyReport")
public class EmergencyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;     // Primary Key

    private Long citizenId;    // Linked to Citizen Module (4.2)

    @Enumerated(EnumType.STRING)
    private EmergencyType type;   // Flood/Earthquake/Fire

    private String location;

    private LocalDateTime date = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    // -------------------------
    // Getters and Setters
    // -------------------------

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public EmergencyType getType() {
        return type;
    }

    public void setType(EmergencyType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }
}