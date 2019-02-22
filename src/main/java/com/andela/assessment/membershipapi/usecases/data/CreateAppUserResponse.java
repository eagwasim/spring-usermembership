package com.andela.assessment.membershipapi.usecases.data;

import lombok.Data;

@Data
public class CreateAppUserResponse {
    private Long id;

    public CreateAppUserResponse(Long id) {
        this.id = id;
    }
}
