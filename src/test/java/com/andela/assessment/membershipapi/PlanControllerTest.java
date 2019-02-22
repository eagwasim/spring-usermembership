package com.andela.assessment.membershipapi;

import com.andela.assessment.membershipapi.domain.repositories.PlanRepository;
import com.andela.assessment.membershipapi.infrastructure.controllers.PlanController;
import com.andela.assessment.membershipapi.usecases.PlanService;
import com.andela.assessment.membershipapi.usecases.impl.PlanServiceImpl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanController.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class PlanControllerTest {

    private final MockMvc mockMvc;


    @TestConfiguration
    private static class PlanIntegrationTestConfig {

    }

    @Before
    public void setUp() {
        // Plan plan = new Plan("Test", PlanTypeConstant.UNLIMITED, null, null);
        //Mockito.when(planRepository.findById(1L)).then()
    }

    @Inject
    public PlanControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


}
