package org.cognizant.disastermanagement.dto.response;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import org.cognizant.disastermanagement.Enum.Role;
import org.cognizant.disastermanagement.Enum.UserStatus;

public class UserResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String name;
    private Role role;
    private String email;
    private String phone;
    private UserStatus status;
    private LocalDateTime createdAt;

    public UserResponseDTO() {}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}