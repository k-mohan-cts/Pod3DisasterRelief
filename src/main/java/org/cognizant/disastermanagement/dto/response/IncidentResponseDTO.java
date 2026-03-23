package org.cognizant.disastermanagement.dto.response;

import lombok.Data;
import org.cognizant.disastermanagement.Enum.IncidentStatus;
import java.time.LocalDateTime;
@Data
public class IncidentResponseDTO {

    private Integer incidentId;
    private Integer reportId;
    private Integer officerId;
    private String actions;
    private LocalDateTime date;



    private IncidentStatus status;

    // Getters and Setters
}