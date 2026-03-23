package org.cognizant.disastermanagement.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecoveryProgramRequestDTO {

    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @Positive(message = "Budget must be greater than zero")
    private double budget;
}