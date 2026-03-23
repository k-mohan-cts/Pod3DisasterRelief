package org.cognizant.disastermanagement.entity;
import  org.cognizant.disastermanagement.entity.User;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@Table(name="AuditLog")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auditLogId;


    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    public void setUser(User user) {
        
        this.user = user;
    }

    private String action;
    private String resource;
    private LocalDateTime timestamp;
    private String ipAddress;
    private String details;

    public AuditLog() {}

    // Getters and Setters
    public int getAuditLogId() { return auditLogId; }
    public void setAuditLogId(int auditLogId) { this.auditLogId = auditLogId; }
    public User getUser() { return user; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getResource() { return resource; }
    public void setResource(String resource) { this.resource = resource; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}