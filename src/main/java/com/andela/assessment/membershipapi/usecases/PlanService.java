package com.andela.assessment.membershipapi.usecases;

import com.andela.assessment.membershipapi.usecases.data.CreatePlanRequest;
import com.andela.assessment.membershipapi.usecases.data.CreatePlanResponse;
import com.andela.assessment.membershipapi.usecases.data.UserOnAPlanResponse;
import com.andela.assessment.membershipapi.usecases.exceptions.GenericInputErrorException;

import java.util.List;

public interface PlanService {
    CreatePlanResponse createPlan(CreatePlanRequest request) throws GenericInputErrorException;

    List<UserOnAPlanResponse> getUsersOnPlan(Long planId) throws GenericInputErrorException;
}
