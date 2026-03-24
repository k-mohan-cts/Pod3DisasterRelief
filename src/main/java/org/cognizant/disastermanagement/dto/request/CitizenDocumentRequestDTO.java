package org.cognizant.disastermanagement.dto.request;

import java.io.Serial;
import java.io.Serializable;

import org.cognizant.disastermanagement.Enum.DocType;
import org.cognizant.disastermanagement.Enum.VerificationStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenDocumentRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Citizen ID must not be null")
    @Positive(message = "Citizen ID must be greater than zero")
    private Integer citizenId;

    @NotNull(message = "Document type must not be null")
    private DocType docType;

    @NotBlank(message = "File URI must not be blank")
    private String fileURI;

    @NotNull(message = "Verification status must not be null")
    private VerificationStatus verificationStatus;
}