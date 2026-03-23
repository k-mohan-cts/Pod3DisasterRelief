package org.cognizant.disastermanagement.dto.response;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class AuditLogResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer auditLogId;
    private String action;
    private String resource;
    private LocalDateTime timestamp;
    private String ipAddress;
    private String details;

    public AuditLogResponseDTO() {}

    public Integer getAuditLogId() {
        return auditLogId;
    }

    public void setAuditLogId(Integer auditLogId) {
        this.auditLogId = auditLogId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "AuditLogResponseDTO{" +
                "auditLogId=" + auditLogId +
                ", action='" + action + '\'' +
                ", resource='" + resource + '\'' +
                '}';
    }
}