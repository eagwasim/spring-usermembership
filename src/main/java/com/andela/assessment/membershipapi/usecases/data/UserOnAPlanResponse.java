package com.andela.assessment.membershipapi.usecases.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserOnAPlanResponse {
    private long userId;
    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;

    public UserOnAPlanResponse(long userId, String firstName, String lastName, LocalDate dateOfBirth) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
