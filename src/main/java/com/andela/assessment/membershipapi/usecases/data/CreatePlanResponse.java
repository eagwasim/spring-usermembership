package com.andela.assessment.membershipapi.usecases.data;

import com.andela.assessment.membershipapi.domain.enumeration.PlanTypeConstant;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePlanResponse {
    private Long id;
    private String name;
    private PlanTypeConstant type;
    private LocalDate startDate;
    private LocalDate endDate;

    public CreatePlanResponse(Long id, String name, PlanTypeConstant type, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CreatePlanResponse() {
    }
}
