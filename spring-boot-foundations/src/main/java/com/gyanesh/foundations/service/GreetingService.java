package com.gyanesh.foundations.service;

import com.gyanesh.foundations.config.LearningServiceProperties;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GreetingService {
    private final LearningServiceProperties properties;
    private final ObjectProvider<LearningBanner> bannerProvider;
    private final Counter greetingRequests;

    public GreetingService(
            LearningServiceProperties properties,
            ObjectProvider<LearningBanner> bannerProvider,
            MeterRegistry meterRegistry) {
        this.properties = Objects.requireNonNull(properties);
        this.bannerProvider = Objects.requireNonNull(bannerProvider);
        this.greetingRequests = meterRegistry.counter(
                "learning.greeting.requests",
                "service", properties.name()
        );
    }

    public GreetingResult greet(String requestedName) {
        String name = requestedName == null || requestedName.isBlank()
                ? "there"
                : requestedName.trim();

        greetingRequests.increment();
        LearningBanner banner = bannerProvider.getIfAvailable();
        String message = "Hello, " + name + "! Welcome to " + properties.name() + ".";
        return new GreetingResult(message, properties.name(), properties.environment(),
                banner != null, banner == null ? "" : banner.message());
    }

    public record GreetingResult(
            String message,
            String serviceName,
            String configuredEnvironment,
            boolean bannerEnabled,
            String bannerMessage) {
    }
}
