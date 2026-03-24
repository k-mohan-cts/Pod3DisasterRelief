package org.cognizant.disastermanagement.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.cognizant.disastermanagement.Enum.shelterStatus;

@Data
public class ShelterRequestDTO {

    @NotBlank(message="Name cannot be blank")
    private String name;

    @NotBlank(message="Location cannot be blank")
    private String location;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private Double longitude;

    @DecimalMin(value = "1", message = "Quantity must be at least 1")
    @NotNull(message = "Capacity cannot be null")
    @Pattern(regexp = "^[0-9]*$", message = "Input must contain only numbers")
    private int capacity;

    @Positive(message="Occupancy cannot be negative")
    @Pattern(regexp = "^[0-9]*$", message = "Input must contain only numbers")
    private int occupancy;

    @NotNull(message = "Status cannot be Empty")
    private shelterStatus status;

    @NotNull(message = "Contact Info cannot be empty")
    @Size(min = 10, max = 10 , message = "The number should be exactly 10 digit long !")
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