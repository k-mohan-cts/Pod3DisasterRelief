package org.cognizant.disastermanagement.entities;

import jakarta.persistence.*;
import org.cognizant.disastermanagement.Enum.reliefStatus;
import org.cognizant.disastermanagement.Enum.type;

import java.time.LocalDateTime;


@Entity
@Table(name="reliefitem")
public class ReliefItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ItemId",nullable=false, unique=true)
    private Integer ItemId;

    @Column(nullable = false)
    private type Type;

    @Column(nullable = false)
    private String Name;

    @Column
    private Integer Quantity;

    @Column
    private String Unit;

    @Column
    private reliefStatus Status;

    @Column
    private LocalDateTime CreatedAt;

    @Column
    private LocalDateTime UpdatedAt;

    public ReliefItem(){}

    public ReliefItem( Integer ItemId, type Type, String Name, Integer Quantity, String Unit, reliefStatus Status, LocalDateTime CreatedAt ,LocalDateTime UpdatedAt){
        this.ItemId = ItemId;
        this.Type = Type;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Unit = Unit;
        this.Status = Status;
        this.CreatedAt = CreatedAt;
        this.UpdatedAt = UpdatedAt;
    }


    public Integer getItemId() {
        return ItemId;
    }

    public void setItemId(Integer itemId) {
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

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getUnit() {
        return Unit;
    }


    public void setUnit(String unit) {
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
