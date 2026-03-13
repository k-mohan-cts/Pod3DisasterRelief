package org.cognizant.disastermanagement.entity;
import jakarta.persistence.*;
import org.cognizant.disastermanagement.enums.CitizenStatus;
import org.cognizant.disastermanagement.enums.Gender;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "Citizen")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CitizenID")
    private Integer citizenId;

    @Column(name = "UserID")
    private Integer userId;   // Linking login account (as per DB schema)

    @Column(name = "Name", nullable = false, length = 150)
    private String name;

    @Column(name = "DOB", nullable = false)
    private LocalDateTime dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender", nullable = false)
    private Gender gender;

    @Column(name = "Address", nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(name = "ContactInfo")
    private String contactInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private CitizenStatus status = CitizenStatus.Pending;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    // ONE Citizen can have MANY Emergency Reports
    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL)
    private List<EmergencyReport> reports;
}
