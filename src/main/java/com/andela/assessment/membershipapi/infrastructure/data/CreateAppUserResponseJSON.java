package com.andela.assessment.membershipapi.infrastructure.data;

import com.andela.assessment.membershipapi.usecases.data.CreateAppUserResponse;
import lombok.Data;

@Data
public class CreateAppUserResponseJSON {
    private Long id;

    public CreateAppUserResponseJSON(CreateAppUserResponse createAppUserResponse) {
        this.id = createAppUserResponse.getId();
    }
}
