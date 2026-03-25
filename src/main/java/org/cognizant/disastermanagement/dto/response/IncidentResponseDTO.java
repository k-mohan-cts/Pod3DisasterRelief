package org.cognizant.disastermanagement.dto.response;

import lombok.Data;
import org.cognizant.disastermanagement.Enum.IncidentStatus;

import java.time.LocalDateTime;

@Data
public class IncidentResponseDTO {

    private int incidentId;
    private int reportId;
    private int officerId;
    private String actions;
    private LocalDateTime date;
    private IncidentStatus status;
}