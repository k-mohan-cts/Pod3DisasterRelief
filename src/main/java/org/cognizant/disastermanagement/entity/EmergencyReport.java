package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.IncidentStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "EmergencyReport")
public class EmergencyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private Long citizenId;

    private EmergencyType type; // Flood / Earthquake / Fire
    private String location;

    private LocalDateTime date = LocalDateTime.now();

    private IncidentStatus status;

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


    public void setStatus(String pending) {
    }
}