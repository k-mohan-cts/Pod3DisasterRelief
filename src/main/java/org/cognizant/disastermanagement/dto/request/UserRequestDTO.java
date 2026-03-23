package org.cognizant.disastermanagement.dto.request;

import java.io.Serial;
import java.io.Serializable;

import org.cognizant.disastermanagement.Enum.Role;
import org.cognizant.disastermanagement.Enum.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private Role role;
    private String email;
    private String phone;
    private String passwordHash;
    private UserStatus status;
}
