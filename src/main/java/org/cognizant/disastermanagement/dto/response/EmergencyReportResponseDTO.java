package org.cognizant.disastermanagement.dto.response;

import lombok.Data;
import org.cognizant.disastermanagement.Enum.EmergencyType;
import org.cognizant.disastermanagement.Enum.ReportStatus;

import java.time.LocalDateTime;
@Data
public class EmergencyReportResponseDTO {



    private Integer reportId;
    private Integer citizenId;
    private EmergencyType type;
    private String location;
    private ReportStatus status;
    private LocalDateTime date;


}