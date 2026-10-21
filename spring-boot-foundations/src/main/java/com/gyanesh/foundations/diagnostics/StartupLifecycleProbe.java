package com.gyanesh.foundations.diagnostics;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/** Logs safe lifecycle milestones so startup behavior is visible during the lab. */
@Component
public class StartupLifecycleProbe implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(StartupLifecycleProbe.class);
    private final Environment environment;

    public StartupLifecycleProbe(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    void initialized() {
        log.info("[learning-lifecycle] StartupLifecycleProbe @PostConstruct completed");
    }

    @Override
    public void run(ApplicationArguments args) {
        log.info("[learning-lifecycle] ApplicationRunner executed; activeProfiles={}",
                Arrays.toString(environment.getActiveProfiles()));
    }

    @PreDestroy
    void shuttingDown() {
        log.info("[learning-lifecycle] StartupLifecycleProbe @PreDestroy invoked during context shutdown");
    }
}
