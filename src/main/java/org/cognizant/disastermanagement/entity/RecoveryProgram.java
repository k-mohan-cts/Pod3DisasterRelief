package org.cognizant.disastermanagement.entity;
import org.cognizant.disastermanagement.Enum.RecoveryStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "recovery_programs")
public class RecoveryProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private int programId;
    private String title;
    private String description;
    @Column(name = "manager_id")
    private int managerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    @Enumerated(EnumType.STRING)
    private RecoveryStatus status;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "recoveryProgram", cascade = CascadeType.ALL)
    private List<Resource> resources = new ArrayList<>();
    public int getProgramId() {
        return programId;
    }
    public void setProgramId(int programId) {
        this.programId = programId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public RecoveryStatus getStatus() {
        return status;
    }
    public void setStatus(RecoveryStatus status) {
        this.status = status;
    }

}