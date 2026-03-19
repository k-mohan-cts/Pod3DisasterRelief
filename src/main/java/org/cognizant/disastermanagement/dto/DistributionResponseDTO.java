package org.cognizant.disastermanagement.dto;

import org.cognizant.disastermanagement.Enum.distributionStatus;
import java.time.LocalDateTime;

public class DistributionResponseDTO {
    private int distributionId;
    private int itemId;
    private int quantity;
    private distributionStatus status;
    private LocalDateTime date;
    private String notes;

    // Getters and Setters
    public int getDistributionId() { return distributionId; }
    public void setDistributionId(int distributionId) { this.distributionId = distributionId; }
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public distributionStatus getStatus() { return status; }
    public void setStatus(distributionStatus status) { this.status = status; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}