package org.cognizant.disastermanagement.entity;
import org.cognizant.disastermanagement.enums.EmergencyType;
import jakarta.persistence.*;
import org.cognizant.disastermanagement.enums.ReportStatus;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "EmergencyReport")

public class EmergencyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportID")
    private Integer reportId;

    // MANY Reports belong to ONE Citizen
    @ManyToOne
    @JoinColumn(name = "CitizenID", nullable = false)
    private Citizen citizen;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false)
    private EmergencyType type;

    @Column(name = "Location", nullable = false, length = 500)
    private String location;

    private Double latitude;
    private Double longitude;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private ReportStatus status = ReportStatus.Submitted;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    // ONE EmergencyReport can have MANY Incidents
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private List<Incident> incidents;
}