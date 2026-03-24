package org.cognizant.disastermanagement.dto.request;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import org.cognizant.disastermanagement.Enum.Gender;
import org.cognizant.disastermanagement.Enum.CitizenStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
public class CitizenRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private LocalDate dob;

    private Gender gender;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    private String contactInfo;

    @NotNull(message = "Status cannot be null")
    private CitizenStatus status;

    @NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be greater than zero")
    private Integer userId;

    // Explicit getters & setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public CitizenStatus getStatus() { return status; }
    public void setStatus(CitizenStatus status) { this.status = status; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
}