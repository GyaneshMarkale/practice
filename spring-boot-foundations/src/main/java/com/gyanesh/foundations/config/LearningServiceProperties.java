package com.gyanesh.foundations.config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

/**
 * Type-safe, validated binding for the learning.service.* configuration group.
 * Keep configuration properties focused on settings rather than injecting services into them.
 */
@Validated
@ConfigurationProperties(prefix = "learning.service")
public record LearningServiceProperties(
        @NotBlank String name,
        @NotBlank String environment,
        @Min(1) @Max(100) int maxItems,
        @NotNull Duration requestTimeout,
        boolean featuresEnabled
) {
}
