package org.cognizant.disastermanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cognizant.disastermanagement.Enum.ResourceStatus;
import org.cognizant.disastermanagement.Enum.ResourceType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Allows for easy mapping: ResourceResponseDTO.builder().name("Water").build();
public class ResourceResponseDTO {
    private int resourceId;
    private String name;
    private ResourceType type;
    private double quantity;
    private String unit;
    private ResourceStatus status;
    private String receivedBy;
    private int programId;
}