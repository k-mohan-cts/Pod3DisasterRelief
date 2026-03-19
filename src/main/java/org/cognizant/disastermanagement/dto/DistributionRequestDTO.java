package org.cognizant.disastermanagement.dto;

import org.cognizant.disastermanagement.Enum.distributionStatus;

public class DistributionRequestDTO {
    private int itemId;
    private int citizenId;
    private int officerId;
    private int quantity;
    private String notes;
    private distributionStatus status;

    // Getters and Setters
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public int getCitizenId() { return citizenId; }
    public void setCitizenId(int citizenId) { this.citizenId = citizenId; }
    public int getOfficerId() { return officerId; }
    public void setOfficerId(int officerId) { this.officerId = officerId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public distributionStatus getStatus() { return status; }
    public void setStatus(distributionStatus status) { this.status = status; }
}