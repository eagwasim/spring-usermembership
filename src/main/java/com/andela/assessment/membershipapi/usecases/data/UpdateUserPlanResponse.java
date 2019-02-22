package com.andela.assessment.membershipapi.usecases.data;

import lombok.Data;

@Data
public class UpdateUserPlanResponse {
    private Long planId;
    private Long userId;

    public UpdateUserPlanResponse(Long planId, Long userId) {
        this.planId = planId;
        this.userId = userId;
    }
}
