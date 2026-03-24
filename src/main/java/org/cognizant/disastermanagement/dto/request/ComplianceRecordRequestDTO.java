package org.cognizant.disastermanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.cognizant.disastermanagement.Enum.ComplianceResult;
import org.cognizant.disastermanagement.Enum.ComplainceType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceRecordRequestDTO {
    @NotNull(message = "Entity ID is required")
    private Integer entityId;

    @NotNull(message = "Compliance Type is required")
    private ComplainceType type;

    private Integer officerId; // The ID of the Compliance Officer
    private ComplianceResult result; // Compliant, NonCompliant, or PendingReview
    private String notes;
}