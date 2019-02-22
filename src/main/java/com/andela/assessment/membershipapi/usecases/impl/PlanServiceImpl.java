package com.andela.assessment.membershipapi.usecases.impl;

import com.andela.assessment.membershipapi.domain.entities.Plan;
import com.andela.assessment.membershipapi.domain.enumeration.PlanTypeConstant;
import com.andela.assessment.membershipapi.domain.repositories.AppUserRepository;
import com.andela.assessment.membershipapi.domain.repositories.PlanRepository;
import com.andela.assessment.membershipapi.usecases.PlanService;
import com.andela.assessment.membershipapi.usecases.data.CreatePlanRequest;
import com.andela.assessment.membershipapi.usecases.data.CreatePlanResponse;
import com.andela.assessment.membershipapi.usecases.data.UserOnAPlanResponse;
import com.andela.assessment.membershipapi.usecases.exceptions.GenericInputErrorException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;
    private final AppUserRepository appUserRepository;

    @Inject
    public PlanServiceImpl(PlanRepository planRepository, AppUserRepository appUserRepository) {
        this.planRepository = planRepository;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public CreatePlanResponse createPlan(CreatePlanRequest request) throws GenericInputErrorException {

        if (request.getType() == PlanTypeConstant.LIMITED) {
            if (request.getStartDate() == null) {
                throw new GenericInputErrorException("Start date should not be null for LIMITED plan");
            }
            if (request.getEndDate() == null) {
                throw new GenericInputErrorException("End date should not be null for LIMITED plan");
            }
            if (request.getEndDate().isBefore(request.getStartDate())) {
                throw new GenericInputErrorException("End date should not be before Start date for LIMITED plan");
            }
        }

        Plan plan = new Plan(request.getName().toUpperCase(), request.getType(), request.getStartDate(), request.getEndDate());

        planRepository.save(plan);

        return new CreatePlanResponse(plan.getId(), plan.getName(), plan.getType(), plan.getStartDate(), plan.getEndDate());
    }

    @Override
    public List<UserOnAPlanResponse> getUsersOnPlan(Long planId) throws GenericInputErrorException {
        Plan plan = planRepository.getOne(planId);

        if (plan == null) {
            throw new GenericInputErrorException("Invalid Plan ID");
        }

        return appUserRepository.findAllByPlanId(planId).stream().map(a -> new UserOnAPlanResponse(a.getId(), a.getFirstName(), a.getLastName(), a.getDateOfBirth())).collect(Collectors.toList());
    }
}
