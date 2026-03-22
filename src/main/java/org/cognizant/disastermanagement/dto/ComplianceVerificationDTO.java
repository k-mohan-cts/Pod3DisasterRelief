package org.cognizant.disastermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.cognizant.disastermanagement.Enum.ComplianceResult;

import java.io.Serializable;

/**
 * DTO for updating compliance record result (Compliant/NonCompliant)
 */
public class ComplianceVerificationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Compliance ID cannot be null")
    private Integer complianceId;

    @NotNull(message = "Result cannot be null")
    private ComplianceResult result;

    @NotBlank(message = "Notes cannot be blank")
    private String notes;

    // Constructors
    public ComplianceVerificationDTO() {
    }

    public ComplianceVerificationDTO(Integer complianceId, ComplianceResult result, String notes) {
        this.complianceId = complianceId;
        this.result = result;
        this.notes = notes;
    }

    // Getters and Setters
    public Integer getComplianceId() {
        return complianceId;
    }

    public void setComplianceId(Integer complianceId) {
        this.complianceId = complianceId;
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
        return "ComplianceVerificationDTO{" +
                "complianceId=" + complianceId +
                ", result=" + result +
                '}';
    }
}
