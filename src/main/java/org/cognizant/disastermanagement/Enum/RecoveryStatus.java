package org.cognizant.disastermanagement.Enum;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum RecoveryStatus {
    Cancelled, Completed, Planned, Active, Suspended;

    @JsonCreator
    public static RecoveryStatus fromString(String value) {
        for (RecoveryStatus status : RecoveryStatus.values()) {
            if (status.name().equalsIgnoreCase(value)) return status;
        }
        return null;
    }
}