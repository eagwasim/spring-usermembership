package com.andela.assessment.membershipapi.domain.entities;

import com.andela.assessment.membershipapi.domain.enumeration.PlanTypeConstant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plan")
@Getter
@Setter
public class Plan extends AbstractJpaEntity<Long> {
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlanTypeConstant type;

    private LocalDate startDate;
    private LocalDate endDate;

    public Plan() {
    }

    public Plan(String name, PlanTypeConstant type, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
