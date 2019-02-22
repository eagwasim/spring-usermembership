package com.andela.assessment.membershipapi.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser extends AbstractJpaEntity<Long> {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn
    private Plan plan;

    public AppUser(String firstName, String lastName, LocalDate dateOfBirth, Plan plan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.plan = plan;
    }

    public AppUser() {

    }
}
