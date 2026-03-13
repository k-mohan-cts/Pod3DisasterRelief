package org.cognizant.disastermanagement.entity;
import jakarta.persistence.*;
import org.cognizant.disastermanagement.Enum.AuditStatus;

import java.time.LocalDateTime;

@Entity
@Table(name="Audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AuditId;
    @ManyToOne
    @JoinColumn(name="user_id")
    private int OfficerId;
    private String Scope;
    private LocalDateTime Created_date_time;
    @Lob
    private String Findings;
    @Enumerated(EnumType.STRING)
    private AuditStatus auditStatus;
    private LocalDateTime updated_At;
    public int getAuditId() {
        return AuditId;
    }

    public void setAuditId(int auditId) {
        AuditId = auditId;
    }

    public int getOfficerId() {
        return OfficerId;
    }

    public void setOfficerId(int officerId) {
        OfficerId = officerId;
    }

    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
    }

    public LocalDateTime getCreated_date_time() {
        return Created_date_time;
    }

    public void setCreated_date_time(LocalDateTime created_date_time) {
        Created_date_time = created_date_time;
    }

    public String getFindings() {
        return Findings;
    }

    public void setFindings(String findings) {
        Findings = findings;
    }

    public AuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public LocalDateTime getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(LocalDateTime updated_At) {
        this.updated_At = updated_At;
    }




}
