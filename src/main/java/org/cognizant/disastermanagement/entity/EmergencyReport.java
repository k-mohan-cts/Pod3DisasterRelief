package org.cognizant.disastermanagement.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.ReportStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "EmergencyReport")
public class EmergencyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmergencyType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportStatus status;

    @Column
    private Double latitude;
    @Column
    private Double longitude;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CitizenID")

    private Citizen citizen;

    @OneToMany(mappedBy = "emergencyReport", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Incident> incidents = new ArrayList<>();

    public EmergencyReport() {}
}