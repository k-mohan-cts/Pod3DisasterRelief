package org.cognizant.disastermanagement.entity;
import jakarta.persistence.*;
import org.cognizant.disastermanagement.enums.ReportStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "Incident")

public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IncidentID")
    private Integer incidentId;

    // MANY Incidents belong to ONE EmergencyReport
    @ManyToOne
    @JoinColumn(name = "ReportID", nullable = false)
    private EmergencyReport report;

    // MANY incidents handled by ONE officer (User)
    @ManyToOne
    @JoinColumn(name = "OfficerID", nullable = false)
    private User officer;

    @Column(nullable = false)
    private String actions;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportStatus status ;

    private String notes;

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}