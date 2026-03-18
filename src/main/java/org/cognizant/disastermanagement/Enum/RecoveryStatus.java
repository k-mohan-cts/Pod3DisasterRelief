package org.cognizant.disastermanagement.Enum;

public enum RecoveryStatus {
    Cancelled, Completed, Planned, Active, Suspended;

    // Add this to accept "PLANNED" or "planned" from Postman
    @com.fasterxml.jackson.annotation.JsonCreator
    public static RecoveryStatus fromString(String value) {
        for (RecoveryStatus status : RecoveryStatus.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        return null;
    }
}