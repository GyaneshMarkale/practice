# Module 2 — Interview Questions and Knowledge Check

Answer from memory. For each question, state the principle, give a practical example, and mention a trade-off or failure mode.

## Configuration and profiles

1. What is externalized configuration, and why is it useful in a service deployed to multiple environments?
2. Compare `@Value` with `@ConfigurationProperties`.
3. How do you register a type annotated with `@ConfigurationProperties`?
4. How would you validate a numeric property to allow only values from 1 through 100?
5. What happens when a validation constraint fails during property binding at startup?
6. Explain the roles of `application.yaml`, `application-local.yaml`, and `application-prod.yaml`.
7. How would you prove whether a command-line argument overrides an environment variable and a YAML value?
8. Why should application code not hard-code production URLs, credentials, or resource limits?

## Auto-configuration and startup

9. What does `@SpringBootApplication` combine?
10. Explain `@ConditionalOnClass`, `@ConditionalOnMissingBean`, and `@ConditionalOnProperty`.
11. How do you investigate why a default bean was configured or skipped?
12. Why can defining your own bean cause Boot's default auto-configuration to back off?
13. Compare a starter, auto-configuration, and dependency management.
14. Why is the main application class commonly placed at the root package?
15. What happens when a required dependency is not discovered during component scanning?
16. Describe the high-level startup sequence and explain where `ApplicationRunner` runs.

## Actuator and operations

17. What do health, liveness, readiness, info, and metrics tell you?
18. Why can a service be healthy while latency is unacceptable?
19. Why should `env`, `configprops`, `beans`, and `conditions` not automatically be exposed publicly?
20. How would you verify that a custom metric is increasing?
21. How is local profile exposure different from the production exposure policy in this project?
22. What should a production-readiness review check besides whether the health endpoint returns UP?

## Trade-offs / senior-level

23. What are the advantages and costs of convention-over-configuration?
24. How can starters contribute to dependency bloat or conflicts?
25. When would you investigate startup time instead of changing configuration blindly?
26. Why should configuration classes remain small and avoid expensive remote calls during bean construction?
27. What is the difference between application-owned conditional configuration and Boot-provided auto-configuration?
28. How would you explain Spring Boot's rapid-development benefits and operational costs to a team choosing a framework?

## Review rubric (28 points)

Give each answer 0, 0.5, or 1 point: 0 = incorrect/no answer, 0.5 = partial or definition-only, 1 = clear explanation with a concrete example and an appropriate trade-off.

- 24–28: strong; revisit any missed topics and prepare a concise verbal walkthrough of the project.
- 19–23.5: review missed items and repeat the corresponding experiment.
- Below 19: revisit the learning notes before moving to the next module.