package org.cognizant.disastermanagement.Enum;



import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserStatus {
    //ACTIVE, Inactive, Suspended;
ACTIVE,INACTIVE,SUSPENDED;
//    @JsonCreator
//    public static UserStatus fromString(String value) {
//        if (value == null) return null;
//        return UserStatus.valueOf(value.toUpperCase());
//    }
}