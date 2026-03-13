package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import org.cognizant.disastermanagement.Enum.ComplianceResult;
import org.cognizant.disastermanagement.Enum.ComplainceType;

import java.time.LocalDateTime;

public class ComplianceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ComplianceID")
    private int entityId;

    @Column(name = "Date")
    private LocalDateTime dateTime = LocalDateTime.now();

    private int officerId;

    @Lob
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type")
    private ComplainceType complainceType;

    @Enumerated(EnumType.STRING)
    @Column(name = "Result")
    private ComplianceResult complianceResult;
    private int complianceId;

    public int getComplianceId() {
        return complianceId;
    }

    public void setComplianceId(int complianceId) {
        this.complianceId = complianceId;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ComplainceType getComplainceType() {
        return complainceType;
    }

    public void setComplainceType(ComplainceType complainceType) {
        this.complainceType = complainceType;
    }

    public ComplianceResult getComplainceResult() {
        return complianceResult;
    }

    public void setComplainceResult(ComplianceResult complainceResult) {
        this.complianceResult = complainceResult;
    }


}
