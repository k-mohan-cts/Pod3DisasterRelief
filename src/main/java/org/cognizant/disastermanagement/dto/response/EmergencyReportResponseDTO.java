package org.cognizant.disastermanagement.dto.response;

import lombok.Data;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.ReportStatus;

import java.time.LocalDateTime;

@Data
public class EmergencyReportResponseDTO {

    private int reportId;
    private int citizenId;
    private String location;
    private EmergencyType type;
    private ReportStatus status;
    private LocalDateTime date;

    private Double latitude;     // ✅ Added
    private Double longitude;    // ✅ Added
    private String description;  // ✅ Added
}
