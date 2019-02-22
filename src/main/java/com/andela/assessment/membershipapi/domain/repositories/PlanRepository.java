package com.andela.assessment.membershipapi.domain.repositories;

import com.andela.assessment.membershipapi.domain.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
