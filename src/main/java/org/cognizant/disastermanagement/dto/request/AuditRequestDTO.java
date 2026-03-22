package org.cognizant.disastermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.cognizant.disastermanagement.Enum.AuditStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for creating or updating an Audit record
 */
public class AuditRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //@NotNull(message = "Officer ID cannot be null")
    private Integer officerId;

    @NotBlank(message = "Scope cannot be blank")
    private String scope;

    private String findings;

    private AuditStatus status;

    // Constructors
    public AuditRequestDTO() {
    }

    public AuditRequestDTO(Integer officerId, String scope, String findings) {
        this.officerId = officerId;
        this.scope = scope;
        this.findings = findings;
    }

    // Getters and Setters
    public Integer getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public AuditStatus getStatus() {
        return status;
    }

    public void setStatus(AuditStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AuditRequestDTO{" +
                "officerId=" + officerId +
                ", scope='" + scope + '\'' +
                ", findings='" + findings + '\'' +
                ", status=" + status +
                '}';
    }
}
