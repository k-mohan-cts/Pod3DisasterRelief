package org.cognizant.disastermanagement.dto.request;

import java.io.Serial;
import java.io.Serializable;
import org.cognizant.disastermanagement.Enum.Role;
import org.cognizant.disastermanagement.Enum.UserStatus;

public class UserRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private Role role;
    private String email;
    private String phone;
    private String passwordHash;
    private UserStatus status;

    public UserRequestDTO() {}

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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}