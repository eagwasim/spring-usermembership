package com.andela.assessment.membershipapi.infrastructure.data;

import com.andela.assessment.membershipapi.usecases.data.CreatePlanResponse;
import lombok.Data;

@Data
public class CreatePlanResponseJSON {
    private Long id;

    public CreatePlanResponseJSON(CreatePlanResponse createPlanResponse) {
        this.id = createPlanResponse.getId();
    }
}
