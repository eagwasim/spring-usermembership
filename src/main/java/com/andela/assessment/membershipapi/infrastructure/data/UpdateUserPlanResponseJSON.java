package com.andela.assessment.membershipapi.infrastructure.data;

import lombok.Data;

@Data
public class UpdateUserPlanResponseJSON {
    private Long planId;
    private Long userId;

    public UpdateUserPlanResponseJSON(Long planId, Long userId) {
        this.planId = planId;
        this.userId = userId;
    }
}
