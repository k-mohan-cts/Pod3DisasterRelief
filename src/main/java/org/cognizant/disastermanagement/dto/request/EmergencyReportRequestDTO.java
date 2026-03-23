package org.cognizant.disastermanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.ReportStatus;
@Data
public class EmergencyReportRequestDTO {

    @NotNull(message = "Citizen ID is required")
    private Integer citizenId;

    @NotNull(message = "Emergency type is required")
    private EmergencyType type;

    @NotBlank(message = "Location is required")
    private String location;
    @NotNull(message = "Status is required")
    private ReportStatus status;







}