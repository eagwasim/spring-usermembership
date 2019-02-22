package com.andela.assessment.membershipapi.domain.repositories;

import com.andela.assessment.membershipapi.domain.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findAllByPlanId(Long planId);
}
