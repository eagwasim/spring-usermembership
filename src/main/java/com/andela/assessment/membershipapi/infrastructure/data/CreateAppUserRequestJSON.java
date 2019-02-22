package com.andela.assessment.membershipapi.infrastructure.data;

import com.andela.assessment.membershipapi.usecases.data.CreateAppUserRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class CreateAppUserRequestJSON {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String dateOfBirth;

    public CreateAppUserRequest toRequest() {
        return new CreateAppUserRequest(firstName, lastName, LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_DATE));
    }
}
