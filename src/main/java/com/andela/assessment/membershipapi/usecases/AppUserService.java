package com.andela.assessment.membershipapi.usecases;

import com.andela.assessment.membershipapi.usecases.data.CreateAppUserRequest;
import com.andela.assessment.membershipapi.usecases.data.CreateAppUserResponse;
import com.andela.assessment.membershipapi.usecases.data.UpdateUserPlanRequest;
import com.andela.assessment.membershipapi.usecases.data.UpdateUserPlanResponse;
import com.andela.assessment.membershipapi.usecases.exceptions.GenericInputErrorException;

public interface AppUserService {
    CreateAppUserResponse createAppUser(CreateAppUserRequest userRequest);

    UpdateUserPlanResponse updateUserPlan(UpdateUserPlanRequest updateUserPlanRequest) throws GenericInputErrorException;
}
