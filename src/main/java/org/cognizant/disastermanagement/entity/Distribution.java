package org.cognizant.disastermanagement.entity;
import org.cognizant.disastermanagement.Enum.distributionStatus;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "distribution")
public class Distribution {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int distributionId;

    @Column(name="ItemId", nullable = false)
    private int itemId;

    @Column(name="CitizenId")
    private int citizenId;

    @Column(name="OfficerId")
    private int officerId;

    @Column(name="Quantity")
    private int quantity;

    @Column
    private LocalDateTime date;

    @Column
    @Enumerated(EnumType.STRING)
    private distributionStatus status;

    @Column
    private String notes;


    public int getDistributionId() {
        return distributionId;
    }

    public void setDistributionID(int distributionID) {
        this.distributionId = distributionID;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public distributionStatus getStatus() {
        return status;
    }

    public void setStatus(distributionStatus status) {
        this.status = status;
    }


}
