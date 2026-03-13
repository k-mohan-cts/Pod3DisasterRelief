package org.cognizant.disastermanagement.entities;

import jakarta.persistence.*;
import org.cognizant.disastermanagement.entities.reliefStatus;

import java.time.LocalDateTime;



enum type{
        Food,Medicine,Clothing,Water,Shelter_Kit,Other
        }

@Entity
@Table(name="reliefitem")
public class ReliefItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ItemId",nullable=false, unique=true)
    private int ItemId;

    @Column(nullable = false)
    private type Type;

    @Column(nullable = false)
    private String Name;

    @Column
    private int Quantity;

    @Column
    private int Unit;

    @Column
    private reliefStatus Status;

    @Column
    private LocalDateTime CreatedAt;

    @Column
    private LocalDateTime UpdatedAt;

    public ReliefItem(){}

    public ReliefItem( int ItemId, type Type, String Name, int Quantity, int Unit, reliefStatus Status, LocalDateTime CreatedAt ,LocalDateTime UpdatedAt){
        this.ItemId = ItemId;
        this.Type = Type;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Unit = Unit;
        this.Status = Status;
        this.CreatedAt = CreatedAt;
        this.UpdatedAt = UpdatedAt;
    }


    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public type getType() {
        return Type;
    }

    public void setType(type type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getUnit() {
        return Unit;
    }

    public void setUnit(int unit) {
        Unit = unit;
    }

    public reliefStatus getStatus() {
        return Status;
    }

    public void setStatus(reliefStatus status) {
        Status = status;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }


    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }
}
