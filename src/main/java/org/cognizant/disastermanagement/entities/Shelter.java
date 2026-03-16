package org.cognizant.disastermanagement.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

enum shelterStatus {
    Open,Full,Closed,UnderMaintenance;
}

@Entity
@Table(name="Shelter")
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ShelterId;

    @Column
    private String Name;

    @Column
    private String Location;

    @Column
    private Double Latitude;

    @Column
    private Double Longitude;

    @Column
    private int Capacity;

    @Column
    private int Occupancy;

    @Column
    private shelterStatus Status;

    @Column
    private String ContactInfo;

    @Column
    private LocalDateTime CreatedAt;

    @Column
    private LocalDateTime UpdatedAt;


    public int getShelterId() {
        return ShelterId;
    }

    public void setShelterId(int shelterId) {
        ShelterId = shelterId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getOccupancy() {
        return Occupancy;
    }

    public void setOccupancy(int occupancy) {
        Occupancy = occupancy;
    }

    public shelterStatus getStatus() {
        return Status;
    }

    public void setStatus(shelterStatus Status) {
        this.Status = this.Status;
    }

    public String getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(String contactInfo) {
        ContactInfo = contactInfo;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }



}
