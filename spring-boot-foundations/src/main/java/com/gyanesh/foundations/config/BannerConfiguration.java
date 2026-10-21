package com.gyanesh.foundations.config;

import com.gyanesh.foundations.service.LearningBanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Demonstrates application-owned conditional configuration (separate from Boot's auto-configuration). */
@Configuration(proxyBeanMethods = false)
public class BannerConfiguration {

    @Bean
    @ConditionalOnProperty(
            prefix = "learning.banner",
            name = "enabled",
            havingValue = "true",
            matchIfMissing = true
    )
    LearningBanner learningBanner(
            @Value("\${learning.banner.message:Keep learning Spring Boot}") String message) {
        return new LearningBanner(message);
    }
}
