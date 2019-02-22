package com.andela.assessment.membershipapi.usecases.data;

import com.andela.assessment.membershipapi.domain.enumeration.PlanTypeConstant;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CreatePlanRequest {
    private String name;
    private PlanTypeConstant type;
    private LocalDate startDate;
    private LocalDate endDate;

    public CreatePlanRequest(String name, String type, String startDate, String endDate) {
        this.type = PlanTypeConstant.valueOf(type);
        this.name = name;

        if (startDate != null) {
            this.startDate = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_DATE_TIME).toLocalDate();
        }

        if (endDate != null) {
            this.endDate = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_DATE_TIME).toLocalDate();
        }
    }
}
