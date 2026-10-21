package com.gyanesh.foundations.service;

import com.gyanesh.foundations.config.LearningServiceProperties;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GreetingServiceTest {
    @Test
    @SuppressWarnings("unchecked")
    void trimsNameAndUsesFallbackForBlankInput() {
        LearningServiceProperties properties = new LearningServiceProperties(
                "Demo", "test", 10, Duration.ofSeconds(1), true);
        ObjectProvider<LearningBanner> noBanner = mock(ObjectProvider.class);
        when(noBanner.getIfAvailable()).thenReturn(null);
        try (SimpleMeterRegistry registry = new SimpleMeterRegistry()) {
            GreetingService service = new GreetingService(properties, noBanner, registry);
            GreetingService.GreetingResult result = service.greet("   ");
            assertEquals("Hello, there! Welcome to Demo.", result.message());
            assertFalse(result.bannerEnabled());
            assertEquals(1.0, registry.get("learning.greeting.requests").counter().count());
        }
    }
}
