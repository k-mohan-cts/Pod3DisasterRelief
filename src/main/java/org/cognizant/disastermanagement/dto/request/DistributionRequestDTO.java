package org.cognizant.disastermanagement.dto.request;


import lombok.Data;

@Data
public class DistributionRequestDTO {
    private Integer distributionId;
    private Integer itemId;
    private Integer citizenId;
    private Integer officerId;
    private Integer quantity;
    private String notes;

    // Receiving status as a String is much more stable for JSON input
    private String status;

    // Standard Getters and Setters
//    public Integer getDistributionId() { return distributionId; }
//    public void setDistributionId(Integer distributionId) { this.distributionId = distributionId; }
//
//    public Integer getItemId() { return itemId; }
//    public void setItemId(Integer itemId) { this.itemId = itemId; }
//
//    public Integer getCitizenId() { return citizenId; }
//    public void setCitizenId(Integer citizenId) { this.citizenId = citizenId; }
//
//    public Integer getOfficerId() { return officerId; }
//    public void setOfficerId(Integer officerId) { this.officerId = officerId; }
//
//    public Integer getQuantity() { return quantity; }
//    public void setQuantity(Integer quantity) { this.quantity = quantity; }
//
//    public String getNotes() { return notes; }
//    public void setNotes(String notes) { this.notes = notes; }
//
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status; }
}