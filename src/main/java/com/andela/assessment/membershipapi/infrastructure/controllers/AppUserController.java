package com.andela.assessment.membershipapi.infrastructure.controllers;

import com.andela.assessment.membershipapi.infrastructure.data.CreateAppUserRequestJSON;
import com.andela.assessment.membershipapi.infrastructure.data.CreateAppUserResponseJSON;
import com.andela.assessment.membershipapi.infrastructure.data.UpdateUserPlanRequestJSON;
import com.andela.assessment.membershipapi.infrastructure.data.UpdateUserPlanResponseJSON;
import com.andela.assessment.membershipapi.usecases.AppUserService;
import com.andela.assessment.membershipapi.usecases.data.CreateAppUserResponse;
import com.andela.assessment.membershipapi.usecases.data.UpdateUserPlanRequest;
import com.andela.assessment.membershipapi.usecases.data.UpdateUserPlanResponse;
import com.andela.assessment.membershipapi.usecases.exceptions.GenericInputErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@RequestMapping("api/v1/users")
public class AppUserController {
    private final AppUserService appUserService;

    @Inject
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PutMapping("/{userId}/plan")
    @ResponseBody
    public UpdateUserPlanResponseJSON updateUserPlan(@RequestBody @Valid UpdateUserPlanRequestJSON userPlanRequestJSON, @PathVariable("userId") Long userId) throws GenericInputErrorException {
        UpdateUserPlanResponse updateUserPlanResponse = appUserService.updateUserPlan(new UpdateUserPlanRequest(userId, userPlanRequestJSON.getPlanId()));
        return new UpdateUserPlanResponseJSON(updateUserPlanResponse.getUserId(), updateUserPlanResponse.getPlanId());
    }

    @PostMapping
    @ResponseBody
    public CreateAppUserResponseJSON createAppUser(@RequestBody @Valid CreateAppUserRequestJSON requestJSON) {
        CreateAppUserResponse createAppUserResponse = appUserService.createAppUser(requestJSON.toRequest());
        return new CreateAppUserResponseJSON(createAppUserResponse);
    }

}
