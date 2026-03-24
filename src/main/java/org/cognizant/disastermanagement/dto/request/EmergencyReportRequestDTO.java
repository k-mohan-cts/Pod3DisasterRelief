package org.cognizant.disastermanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.ReportStatus;

@Data
public class EmergencyReportRequestDTO {

    @NotNull(message = "Citizen ID is required")
    private Integer citizenId;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Type is required")
    private EmergencyType type;

    @NotNull(message = "Status is required")
    private ReportStatus status;

    private Double latitude;     // ✅ Added
    private Double longitude;    // ✅ Added
    private String description;  // ✅ Added
}
