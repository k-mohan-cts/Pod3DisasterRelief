package org.cognizant.disastermanagement.dto.response;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import org.cognizant.disastermanagement.Enum.Gender;
import org.cognizant.disastermanagement.Enum.CitizenStatus;

public class CitizenResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer citizenId;
    private String name;
    private LocalDate dob;
    private Gender gender;
    private String address;
    private String contactInfo;
    private CitizenStatus status;

    public CitizenResponseDTO() {}

    public Integer getCitizenId() { return citizenId; }
    public void setCitizenId(Integer citizenId) { this.citizenId = citizenId; }

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
}