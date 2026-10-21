package com.gyanesh.foundations.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LearningServicePropertiesValidationTest {
    @Test
    void acceptsValidProperties() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            LearningServiceProperties valid = new LearningServiceProperties(
                    "Foundations", "test", 10, Duration.ofSeconds(2), true);
            assertTrue(validator.validate(valid).isEmpty());
        }
    }

    @Test
    void rejectsBlankNamesAndOutOfRangeItemLimits() {
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            LearningServiceProperties invalid = new LearningServiceProperties(
                    " ", "test", 0, Duration.ofSeconds(2), true);
            assertFalse(validator.validate(invalid).isEmpty());
        }
    }
}
