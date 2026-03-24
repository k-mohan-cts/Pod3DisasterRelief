package org.cognizant.disastermanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cognizant.disastermanagement.Enum.AuditStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditResponseDTO {

    private Integer auditId;
    private Integer officerId;
    private String scope;
    private String findings;
    private AuditStatus status;
    private LocalDateTime date;
    private LocalDateTime updatedAt;
}