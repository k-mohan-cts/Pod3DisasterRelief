package org.cognizant.disastermanagement.dto;

import org.cognizant.disastermanagement.Enum.reliefStatus;
import org.cognizant.disastermanagement.Enum.type;

public class ReliefItemRequestDTO {
    private type type;
    private String name;
    private Integer quantity;
    private String unit;
    private reliefStatus status;

    // Getters and Setters
    public type getType() { return type; }
    public void setType(type type) { this.type = type; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public reliefStatus getStatus() { return status; }
    public void setStatus(reliefStatus status) { this.status = status; }
}