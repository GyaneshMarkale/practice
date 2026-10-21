package com.gyanesh.foundations.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
class GreetingControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void greetingUsesInjectedServiceAndBoundConfiguration() throws Exception {
        mockMvc.perform(get("/api/v1/greeting").param("name", "Gyanesh"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Hello, Gyanesh! Welcome to Spring Boot Foundations."))
                .andExpect(jsonPath("$.configuredEnvironment").value("test"))
                .andExpect(jsonPath("$.bannerEnabled").value(true));
    }

    @Test
    void missingNameUsesSafeDefault() throws Exception {
        mockMvc.perform(get("/api/v1/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Hello, there! Welcome to Spring Boot Foundations."));
    }

    @Test
    void learningConfigEndpointShowsAllowlistedPropertiesOnly() throws Exception {
        mockMvc.perform(get("/api/v1/config"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.configuredEnvironment").value("test"))
                .andExpect(jsonPath("$.maxItems").value(5))
                .andExpect(jsonPath("$.requestTimeout").value("PT0.5S"))
                .andExpect(jsonPath("$.activeProfiles[0]").value("test"));
    }
}
