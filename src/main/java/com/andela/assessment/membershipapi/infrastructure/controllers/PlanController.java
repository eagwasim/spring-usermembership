package com.andela.assessment.membershipapi.infrastructure.controllers;

import com.andela.assessment.membershipapi.infrastructure.data.CreatePlanRequestJSON;
import com.andela.assessment.membershipapi.infrastructure.data.CreatePlanResponseJSON;
import com.andela.assessment.membershipapi.infrastructure.data.UserOnAPlanResponseJSON;
import com.andela.assessment.membershipapi.usecases.PlanService;
import com.andela.assessment.membershipapi.usecases.data.CreatePlanResponse;
import com.andela.assessment.membershipapi.usecases.exceptions.GenericInputErrorException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/plans")
public class PlanController {

    private final PlanService planService;

    @Inject
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    @ResponseBody
    public CreatePlanResponseJSON createPlan(@Valid @RequestBody CreatePlanRequestJSON createPlanRequestJSON) throws GenericInputErrorException {
        CreatePlanResponse createPlanResponse = planService.createPlan(createPlanRequestJSON.getCreatePlanRequest());
        return new CreatePlanResponseJSON(createPlanResponse);
    }

    @ResponseBody
    @GetMapping("/{planId}")
    public List<UserOnAPlanResponseJSON> getPlanUsers(@PathVariable("planId") Long planId) throws GenericInputErrorException {
        return planService.getUsersOnPlan(planId).stream().map(a -> new UserOnAPlanResponseJSON(a.getUserId(), a.getFirstName(), a.getLastName(), a.getDateOfBirth())).collect(Collectors.toList());
    }
}
