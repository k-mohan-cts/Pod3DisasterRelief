package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "distribution")
public class Distribution {

    @Id
    private int DistributionID;

    @Column(name="ItemId", nullable = false)
    private int ItemId;

    @Column(name="CitizenId")
    private int CitizenId;

    @Column(name="OfficerId")
    private int OfficerId;

    @Column
    private int Quantity;

    @Column
    private LocalDateTime Date;

    @Column
    private String Notes;


    public int getCitizenId() {
        return CitizenId;
    }

    public void setCitizenId(int citizenId) {
        CitizenId = citizenId;
    }

    public int getDistributionID() {
        return DistributionID;
    }

    public void setDistributionID(int distributionID) {
        DistributionID = distributionID;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getOfficerId() {
        return OfficerId;
    }

    public void setOfficerId(int officerId) {
        OfficerId = officerId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }


    enum distributionStatus {
        Pending, Approved, Distributed, Cancelled;
    }
}
