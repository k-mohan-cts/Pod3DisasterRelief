package org.cognizant.disastermanagement.dto;

import org.cognizant.disastermanagement.Enum.AuditStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for responding with Audit data
 */
public class AuditResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer auditId;
    private Integer officerId;
    private String officerName;
    private String scope;
    private String findings;
    private AuditStatus status;
    private LocalDateTime date;
    private LocalDateTime updatedAt;

    // Constructors
    public AuditResponseDTO() {
    }

    public AuditResponseDTO(Integer auditId, Integer officerId, String officerName, String scope, 
                           String findings, AuditStatus status, LocalDateTime date, LocalDateTime updatedAt) {
        this.auditId = auditId;
        this.officerId = officerId;
        this.officerName = officerName;
        this.scope = scope;
        this.findings = findings;
        this.status = status;
        this.date = date;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "AuditResponseDTO{" +
                "auditId=" + auditId +
                ", officerId=" + officerId +
                ", officerName='" + officerName + '\'' +
                ", scope='" + scope + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}
