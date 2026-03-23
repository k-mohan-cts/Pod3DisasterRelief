package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "AuditLog")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuditLogID")
    private int auditLogId;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "Action", nullable = false)
    private String action;

    @Column(name = "Resource", nullable = false)
    private String resource;

    @CreationTimestamp
    @Column(name = "Timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp;

    @Column(name = "IPAddress")
    private String ipAddress;

    @Column(name = "Details", columnDefinition = "TEXT")
    private String details;

    // Standard Getters and Setters
    public int getAuditLogId() { return auditLogId; }
    public void setAuditLogId(int auditLogId) { this.auditLogId = auditLogId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
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