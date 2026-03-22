package org.cognizant.disastermanagement.dto;

import org.cognizant.disastermanagement.Enum.ComplianceResult;
import org.cognizant.disastermanagement.Enum.ComplainceType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for responding with Compliance Record data
 */
public class ComplianceRecordResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer complianceId;
    private Integer entityId;
    private ComplainceType type;
    private ComplianceResult result;
    private Integer officerId;
    private String officerName;
    private LocalDateTime date;
    private String notes;

    // Constructors
    public ComplianceRecordResponseDTO() {
    }

    public ComplianceRecordResponseDTO(Integer complianceId, Integer entityId, ComplainceType type,
                                      ComplianceResult result, Integer officerId, String officerName,
                                      LocalDateTime date, String notes) {
        this.complianceId = complianceId;
        this.entityId = entityId;
        this.type = type;
        this.result = result;
        this.officerId = officerId;
        this.officerName = officerName;
        this.date = date;
        this.notes = notes;
    }

    // Getters and Setters
    public Integer getComplianceId() {
        return complianceId;
    }

    public void setComplianceId(Integer complianceId) {
        this.complianceId = complianceId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public ComplainceType getType() {
        return type;
    }

    public void setType(ComplainceType type) {
        this.type = type;
    }

    public ComplianceResult getResult() {
        return result;
    }

    public void setResult(ComplianceResult result) {
        this.result = result;
    }

    public Integer getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "ComplianceRecordResponseDTO{" +
                "complianceId=" + complianceId +
                ", entityId=" + entityId +
                ", type=" + type +
                ", result=" + result +
                ", officerName='" + officerName + '\'' +
                ", date=" + date +
                '}';
    }
}
