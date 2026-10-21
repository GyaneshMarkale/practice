package com.gyanesh.foundations.config;

import com.gyanesh.foundations.service.LearningBanner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BannerConfigurationTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(BannerConfiguration.class);

    @Test
    void bannerBeanExistsWhenPropertyIsTrue() {
        contextRunner.withPropertyValues("learning.banner.enabled=true")
                .run(context -> assertTrue(context.getBeansOfType(LearningBanner.class).size() == 1));
    }

    @Test
    void bannerBeanIsSkippedWhenPropertyIsFalse() {
        contextRunner.withPropertyValues("learning.banner.enabled=false")
                .run(context -> assertFalse(context.containsBean("learningBanner")));
    }
}
