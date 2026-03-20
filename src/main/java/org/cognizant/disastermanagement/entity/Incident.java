package org.cognizant.disastermanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.cognizant.disastermanagement.Enum.IncidentStatus;
import org.cognizant.disastermanagement.dto.IncidentDTO;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IncidentID")
    private int incidentId;

    @Column(name = "Actions", nullable = false, length = 1000)
    private String actions;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private IncidentStatus status;

    @CreationTimestamp
    @Column(name = "CreatedAt", updatable = false)
    private LocalDateTime date;

    // MANY Incidents → ONE EmergencyReport
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ReportID")
    @JsonBackReference
    private EmergencyReport emergencyReport;

    // MANY Incidents → ONE Officer (User with role = OFFICER)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OfficerID")
    private User officer;

    public Incident() {}

    public Incident(IncidentDTO dto) {
        this.incidentId = dto.getIncidentId();
        this.actions = dto.getActions();
        this.status = dto.getStatus();
        this.date = dto.getDate();
    }

    // GETTERS & SETTERS

    public int getIncidentId() { return incidentId; }
    public void setIncidentId(int incidentId) { this.incidentId = incidentId; }

    public String getActions() { return actions; }
    public void setActions(String actions) { this.actions = actions; }

    public IncidentStatus getStatus() { return status; }
    public void setStatus(IncidentStatus status) { this.status = status; }

    public LocalDateTime getDate() { return date; }

    public EmergencyReport getEmergencyReport() { return emergencyReport; }
    public void setEmergencyReport(EmergencyReport emergencyReport) { this.emergencyReport = emergencyReport; }

    public User getOfficer() { return officer; }
    public void setOfficer(User officer) { this.officer = officer; }
}