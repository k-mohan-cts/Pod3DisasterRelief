package org.cognizant.disastermanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import org.cognizant.disastermanagement.Enum.Role;
import org.cognizant.disastermanagement.Enum.UserStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private Role role;

    @Column(name = "Email", unique = true, nullable = false)
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private UserStatus status;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private Citizen citizen;

    @CreationTimestamp
    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime updatedAt;
}
