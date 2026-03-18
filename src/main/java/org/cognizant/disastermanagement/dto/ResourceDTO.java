package org.cognizant.disastermanagement.dto;

import org.cognizant.disastermanagement.Enum.ResourceStatus;
import org.cognizant.disastermanagement.Enum.ResourceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ResourceDTO {
    private int resourceId;

    @NotBlank(message = "Resource name is required")
    private String name;

    private ResourceType type;

    @Positive(message = "Quantity must be a positive number")
    private double quantity;

    private String unit;
    private ResourceStatus status;
    private int programId;
    public int getResourceId() { return resourceId; }
    public void setResourceId(int resourceId) { this.resourceId = resourceId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public ResourceType getType() { return type; }
    public void setType(ResourceType type) { this.type = type; }
    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public ResourceStatus getStatus() { return status; }
    public void setStatus(ResourceStatus status) { this.status = status; }
    public int getProgramId() { return programId; }
    public void setProgramId(int programId) { this.programId = programId; }
}