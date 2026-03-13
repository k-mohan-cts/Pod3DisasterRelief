package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Citizen")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int citizenId;

    @OneToOne
    @JoinColumn(name = "UserID")
    private User user;

    private String name;
    private LocalDate dob;
    private String gender;
    private String address;
    private String contactInfo;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Citizen() {}

    // Getters and Setters
    public int getCitizenId() { return citizenId; }
    public void setCitizenId(int citizenId) { this.citizenId = citizenId; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}