package org.cognizant.disastermanagement.dto;

import jakarta.validation.constraints.NotNull;
import org.cognizant.disastermanagement.Enum.ComplianceResult;
import org.cognizant.disastermanagement.Enum.ComplainceType;

import java.io.Serializable;

/**
 * DTO for creating or updating a Compliance Record
 */
public class ComplianceRecordRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Entity ID cannot be null")
    private Integer entityId;

    @NotNull(message = "Type cannot be null")
    private ComplainceType type;

    private Integer officerId;

    private ComplianceResult result;

    private String notes;

    // Constructors
    public ComplianceRecordRequestDTO() {
    }

    public ComplianceRecordRequestDTO(Integer entityId, ComplainceType type) {
        this.entityId = entityId;
        this.type = type;
    }

    public ComplianceRecordRequestDTO(Integer entityId, ComplainceType type, Integer officerId) {
        this.entityId = entityId;
        this.type = type;
        this.officerId = officerId;
    }

    // Getters and Setters
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

    public Integer getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
    }

    public ComplianceResult getResult() {
        return result;
    }

    public void setResult(ComplianceResult result) {
        this.result = result;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "ComplianceRecordRequestDTO{" +
                "entityId=" + entityId +
                ", type=" + type +
                ", officerId=" + officerId +
                ", result=" + result +
                '}';
    }
}
