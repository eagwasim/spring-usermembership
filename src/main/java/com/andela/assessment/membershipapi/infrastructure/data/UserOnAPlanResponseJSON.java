package com.andela.assessment.membershipapi.infrastructure.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserOnAPlanResponseJSON {
    private long userId;
    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;

    public UserOnAPlanResponseJSON(long userId, String firstName, String lastName, LocalDate dateOfBirth) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public UserOnAPlanResponseJSON() {
    }
}
