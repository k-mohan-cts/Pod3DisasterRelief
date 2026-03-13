package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.cognizant.disastermanagement.Enum.Role;
import org.cognizant.disastermanagement.Enum.UserStatus;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public UserStatus getStatus() { return status; }
    public void setStatus(UserStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}