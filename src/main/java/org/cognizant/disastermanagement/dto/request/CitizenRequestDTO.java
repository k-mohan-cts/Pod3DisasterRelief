package org.cognizant.disastermanagement.dto.request;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import org.cognizant.disastermanagement.Enum.Gender;
import org.cognizant.disastermanagement.Enum.CitizenStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private LocalDate dob;
    private Gender gender;
    private String address;
    private String contactInfo;
    private CitizenStatus status;
    private Integer userId;
}