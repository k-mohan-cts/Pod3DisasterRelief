package org.cognizant.disastermanagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.ReportStatus;
import org.cognizant.disastermanagement.dto.EmergencyReportDTO;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EmergencyReport")
public class EmergencyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportID")
    private Integer reportId;

    @Column(name = "Location", nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false)
    private EmergencyType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private ReportStatus status;

    @CreationTimestamp
    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime date;

    // MANY Reports -> ONE Citizen
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CitizenID")
    @JsonBackReference
    private Citizen citizen;

    // ONE Report -> MANY Incidents
    @OneToMany(mappedBy = "emergencyReport", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Incident> incidents = new ArrayList<>();

    public EmergencyReport() {}

    public EmergencyReport(EmergencyReportDTO dto) {
        this.reportId = dto.getReportId();
        this.location = dto.getLocation();
        this.type = dto.getType();
        this.status = dto.getStatus();
        this.date = dto.getDate();
    }

    // GETTERS & SETTERS

    public Integer getReportId() { return reportId; }
    public void setReportId(Integer reportId) { this.reportId = reportId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public EmergencyType getType() { return type; }
    public void setType(EmergencyType type) { this.type = type; }

    public ReportStatus getStatus() { return status; }
    public void setStatus(ReportStatus status) { this.status = status; }

    public LocalDateTime getDate() { return date; }

    public Citizen getCitizen() { return citizen; }
    public void setCitizen(Citizen citizen) { this.citizen = citizen; }

    public List<Incident> getIncidents() { return incidents; }
    public void setIncidents(List<Incident> incidents) { this.incidents = incidents; }
}