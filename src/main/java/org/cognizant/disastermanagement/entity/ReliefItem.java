package org.cognizant.disastermanagement.entity;

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
    private Integer itemId;

    @Column(nullable = false)
    private type type;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer quantity;

    @Column
    private String unit;

    @Column
    private reliefStatus status;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    public ReliefItem(){}

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public reliefStatus getStatus() {
        return status;
    }

    public void setStatus(reliefStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ReliefItem(Integer itemId, type type, String name, Integer quantity, String unit, reliefStatus status, LocalDateTime createdAt , LocalDateTime updatedAt){
        this.itemId = itemId;
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



}
