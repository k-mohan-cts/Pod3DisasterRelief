package org.cognizant.disastermanagement.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.cognizant.disastermanagement.Enum.ResourceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Data                // Generates Getters, Setters, toString, equals, and hashCode
@NoArgsConstructor   // Generates the default constructor
@AllArgsConstructor  // Generates constructor with all fields
public class ResourceRequestDTO {

    private int programId;

    @NotBlank(message = "Resource name is required")
    private String name;

    private ResourceType type;

    @Positive(message = "Quantity must be greater than zero")
    private double quantity;

    private String unit;
}