package com.andela.assessment.membershipapi.infrastructure.data;

import com.andela.assessment.membershipapi.usecases.data.CreatePlanRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class CreatePlanRequestJSON {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Pattern(regexp = "(LIMITED|UNLIMITED|limited|unlimited)")
    private String type;
    private String startDate;
    private String endDate;


    public CreatePlanRequest getCreatePlanRequest() {
        return new CreatePlanRequest(this.name, this.type, this.startDate, this.endDate);
    }
}
