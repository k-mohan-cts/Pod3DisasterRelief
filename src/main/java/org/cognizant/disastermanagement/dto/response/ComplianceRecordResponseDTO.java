package org.cognizant.disastermanagement.dto.response;

import lombok.*;
import org.cognizant.disastermanagement.Enum.ComplianceResult;
import org.cognizant.disastermanagement.Enum.ComplainceType;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceRecordResponseDTO {
    private Integer complianceId;
    private Integer entityId;
    private ComplainceType type;
    private ComplianceResult result;
    private LocalDateTime date;
    private Integer officerId;
    private String notes;
}