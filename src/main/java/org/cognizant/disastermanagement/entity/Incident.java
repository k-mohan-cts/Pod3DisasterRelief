package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import org.cognizant.disastermanagement.Enum.IncidentStatus;
import java.time.LocalDateTime;

@Entity
@Table(name = "Incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incidentId;

    private Long reportId;      // Links to EmergencyReport
    private Long officerId;     // Assigned Relief Officer

    @Column(length = 1000)
    private String actions;     // Actions taken by officer

    private LocalDateTime date = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private IncidentStatus status;

    // Getters and Setters

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Long officerId) {
        this.officerId = officerId;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }
}