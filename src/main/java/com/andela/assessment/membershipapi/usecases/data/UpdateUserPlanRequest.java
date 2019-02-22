package com.andela.assessment.membershipapi.usecases.data;

import lombok.Data;

@Data
public class UpdateUserPlanRequest {
    private Long userId;
    private Long planId;

    public UpdateUserPlanRequest(Long userId, Long planId) {
        this.userId = userId;
        this.planId = planId;
    }
}
