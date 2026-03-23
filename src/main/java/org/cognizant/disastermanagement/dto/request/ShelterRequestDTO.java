package org.cognizant.disastermanagement.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.cognizant.disastermanagement.Enum.shelterStatus;
import jakarta.validation.constraints.NotNull;

@Data
public class ShelterRequestDTO {

    @NotBlank(message="Name cannot be blank")
    private String name;

    @NotBlank(message="Location cannot be blank")
    private String location;

    @NotNull(message="coordinates cant be empty")
    private Double latitude;

    @NotNull(message="coordinates cant be empty")
    private Double longitude;

    @DecimalMin(value = "1", message = "Quantity must be at least 1")
    private int capacity;

    @Positive(message="Occupancy cannot be negative")
    private int occupancy;

    private shelterStatus status;

    @NotNull
    private String contactInfo;

    // Standard Getters and Setters
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    public String getLocation() { return location; }
//    public void setLocation(String location) { this.location = location; }
//    public Double getLatitude() { return latitude; }
//    public void setLatitude(Double latitude) { this.latitude = latitude; }
//    public Double getLongitude() { return longitude; }
//    public void setLongitude(Double longitude) { this.longitude = longitude; }
//    public int getCapacity() { return capacity; }
//    public void setCapacity(int capacity) { this.capacity = capacity; }
//    public int getOccupancy() { return occupancy; }
//    public void setOccupancy(int occupancy) { this.occupancy = occupancy; }
//    public shelterStatus getStatus() { return status; }
//    public void setStatus(shelterStatus status) { this.status = status; }
//    public String getContactInfo() { return contactInfo; }
//    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}