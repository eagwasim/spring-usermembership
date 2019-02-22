package com.andela.assessment.membershipapi.usecases.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateAppUserRequest {
    private String firstName;
    private String lastName;

    private LocalDate dateOfBirth;

    public CreateAppUserRequest(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
