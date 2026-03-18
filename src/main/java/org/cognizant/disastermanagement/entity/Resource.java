package org.cognizant.disastermanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.cognizant.disastermanagement.Enum.ResourceType;
import org.cognizant.disastermanagement.Enum.ResourceStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "Resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResourceID")
    private int resourceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProgramID", nullable = false)
    @JsonBackReference
    private RecoveryProgram recoveryProgram;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false)
    private ResourceType type;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Quantity")
    private double quantity;

    @Column(name = "Unit")
    private String unit;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private ResourceStatus status;

    public Resource() {}

    // --- GETTERS AND SETTERS ---
    public int getResourceId() { return resourceId; }
    public void setResourceId(int resourceId) { this.resourceId = resourceId; }

    public RecoveryProgram getRecoveryProgram() { return recoveryProgram; }
    public void setRecoveryProgram(RecoveryProgram recoveryProgram) { this.recoveryProgram = recoveryProgram; }

    public ResourceType getType() { return type; }
    public void setType(ResourceType type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public ResourceStatus getStatus() { return status; }
    public void setStatus(ResourceStatus status) { this.status = status; }
}