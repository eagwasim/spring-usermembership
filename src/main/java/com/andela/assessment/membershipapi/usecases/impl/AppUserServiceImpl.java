package com.andela.assessment.membershipapi.usecases.impl;

import com.andela.assessment.membershipapi.domain.entities.AppUser;
import com.andela.assessment.membershipapi.domain.entities.Plan;
import com.andela.assessment.membershipapi.domain.repositories.AppUserRepository;
import com.andela.assessment.membershipapi.domain.repositories.PlanRepository;
import com.andela.assessment.membershipapi.usecases.AppUserService;
import com.andela.assessment.membershipapi.usecases.data.CreateAppUserRequest;
import com.andela.assessment.membershipapi.usecases.data.CreateAppUserResponse;
import com.andela.assessment.membershipapi.usecases.data.UpdateUserPlanRequest;
import com.andela.assessment.membershipapi.usecases.data.UpdateUserPlanResponse;
import com.andela.assessment.membershipapi.usecases.exceptions.GenericInputErrorException;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final PlanRepository planRepository;

    @Inject
    public AppUserServiceImpl(AppUserRepository appUserRepository, PlanRepository planRepository) {
        this.appUserRepository = appUserRepository;
        this.planRepository = planRepository;
    }

    @Override
    public CreateAppUserResponse createAppUser(CreateAppUserRequest userRequest) {
        AppUser appUser = new AppUser(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getDateOfBirth(), null);
        appUserRepository.save(appUser);
        return new CreateAppUserResponse(appUser.getId());
    }

    @Override
    public UpdateUserPlanResponse updateUserPlan(UpdateUserPlanRequest updateUserPlanRequest) throws GenericInputErrorException {
        Plan plan = planRepository.getOne(updateUserPlanRequest.getPlanId());

        if (plan == null) {
            throw new GenericInputErrorException("Invalid Plan ID");
        }

        AppUser appUser = appUserRepository.getOne(updateUserPlanRequest.getUserId());

        if (appUser == null) {
            throw new GenericInputErrorException("Invalid User ID");
        }

        appUser.setPlan(plan);

        appUserRepository.save(appUser);

        return new UpdateUserPlanResponse(plan.getId(), appUser.getId());
    }
}
