package org.cognizant.disastermanagement.dto.request;

import lombok.Data;
import org.cognizant.disastermanagement.Enum.shelterStatus;

@Data
public class ShelterRequestDTO {
    private String name;
    private String location;
    private Double latitude;
    private Double longitude;
    private int capacity;
    private int occupancy;
    private shelterStatus status;
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