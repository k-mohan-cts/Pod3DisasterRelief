package org.cognizant.disastermanagement.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum Role {
    //Citizen, Officer, MANAGER, Admin, Compliance, Auditor;
    CITIZEN, OFFICER, MANAGER, ADMIN, COMPLIANCE, AUDITOR
    /*@JsonCreator
    public static Role fromString(String value) {
        // This handles "Manager", "manager", or "MANAGER" from Postman
        return Stream.of(Role.values())
                .filter(r -> r.name().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }*/
}