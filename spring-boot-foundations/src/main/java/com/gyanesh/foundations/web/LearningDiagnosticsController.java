package com.gyanesh.foundations.web;

import com.gyanesh.foundations.config.LearningServiceProperties;
import com.gyanesh.foundations.service.LearningBanner;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/** Learning-only diagnostics. This controller is not registered in the prod profile. */
@RestController
@RequestMapping("/api/v1")
@Profile({"local", "test"})
public class LearningDiagnosticsController {
    private final LearningServiceProperties properties;
    private final ObjectProvider<LearningBanner> bannerProvider;
    private final Environment environment;

    public LearningDiagnosticsController(
            LearningServiceProperties properties,
            ObjectProvider<LearningBanner> bannerProvider,
            Environment environment) {
        this.properties = properties;
        this.bannerProvider = bannerProvider;
        this.environment = environment;
    }

    /** Returns an allowlist of harmless settings, never a dump of all Environment properties. */
    @GetMapping("/config")
    public EffectiveConfigResponse configuration() {
        List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
        return new EffectiveConfigResponse(
                properties.name(),
                properties.environment(),
                activeProfiles,
                properties.maxItems(),
                properties.requestTimeout().toString(),
                properties.featuresEnabled(),
                bannerProvider.getIfAvailable() != null
        );
    }

    public record EffectiveConfigResponse(
            String serviceName,
            String configuredEnvironment,
            List<String> activeProfiles,
            int maxItems,
            String requestTimeout,
            boolean featuresEnabled,
            boolean bannerEnabled) {
    }
}
