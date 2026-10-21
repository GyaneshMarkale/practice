# Module 2 — Spring Boot Configuration, Actuator and Startup

## Why this module exists

Module 1 covered IoC and dependency injection conceptually. This module turns those concepts into a runnable service and focuses on Spring Boot's conventions: configuration outside code, profile-specific behavior, type-safe property binding, Actuator, and inspecting startup/auto-configuration.

## Version and prerequisites

This project uses Spring Boot 4.1.1 and Java 21. The official Spring Boot system requirements page says Boot 4.1.1 requires Java 17 or later and Maven 3.6.3 or later; this lab targets Java 21. Boot 4 also offers modular starters such as `spring-boot-starter-webmvc` and `spring-boot-starter-webmvc-test`, so the POM uses those rather than the older deprecated `spring-boot-starter-web` name.

Reference:
- https://docs.spring.io/spring-boot/system-requirements.html
- https://docs.spring.io/spring-boot/reference/using/build-systems.html

## 1. Project architecture

```text
HTTP request
    |
    v
GreetingController (@RestController)
    |
    v
GreetingService (@Service) -----------------> MeterRegistry
    |                                            custom counter
    +---- LearningServiceProperties              learning.greeting.requests
    |     (@ConfigurationProperties)
    |
    +---- ObjectProvider<LearningBanner>
               |
               +-- BannerConfiguration creates bean only when condition matches

ApplicationContext
  +-- component-scans @Component / @Service / @RestController
  +-- binds and validates LearningServiceProperties
  +-- auto-configures MVC, embedded Tomcat, JSON support and Actuator
  +-- creates lifecycle callbacks and metric infrastructure
```

### Files to inspect first

- `FoundationsApplication.java`: `@SpringBootApplication` and `@ConfigurationPropertiesScan`.
- `LearningServiceProperties.java`: type-safe settings and Jakarta validation constraints.
- `BannerConfiguration.java`: application-owned `@ConditionalOnProperty` demonstration.
- `GreetingService.java`: constructor injection, optional bean resolution and custom metric counter.
- `GreetingController.java`: the public greeting endpoint.
- `LearningDiagnosticsController.java`: profile-limited learning endpoint with a small explicit allowlist of settings; it is absent under `prod`.
- `StartupLifecycleProbe.java`: `@PostConstruct`, `ApplicationRunner`, and `@PreDestroy` log milestones.
- `application.yaml` and `application-{profile}.yaml`: defaults and per-environment overrides.

## 2. IoC and component scanning

`@SpringBootApplication` combines Boot configuration, auto-configuration enablement and component scanning. Scanning begins from the package containing `FoundationsApplication` and includes subpackages by default. Keep your main application class near the root of your package hierarchy.

`@RestController`, `@Service`, and `@Component` register classes for component scanning. `@Configuration` registers bean methods. `@Bean` creates a bean from a method return value. A `@ConditionalOnProperty` annotation controls whether our `LearningBanner` bean is registered.

The `GreetingService` has required dependencies in its constructor. `ObjectProvider<LearningBanner>` is used intentionally because the banner bean is optional. If `learning.banner.enabled=false`, the service still starts and returns `bannerEnabled=false`.

## 3. Externalized configuration

The application binary stays the same; configuration can change by environment. Values are sourced from application YAML, profile-specific YAML, environment variables, and command-line arguments. Higher-precedence sources can override lower-precedence ones; command-line arguments are typically a convenient high-priority override.

Important property-source details are version-specific enough that the current official guide should be used when needed:
https://docs.spring.io/spring-boot/reference/features/external-config.html

For this lab:

- `application.yaml`: safe defaults and minimal actuator exposure.
- `application-local.yaml`: binds the web server to `127.0.0.1`, sets local values and exposes extra diagnostic endpoints for learning.
- `application-test.yaml`: predictable settings for integration tests.
- `application-prod.yaml`: demonstrates environment-variable overrides and minimal actuator exposure.

Activate a profile with `--spring.profiles.active=local` or `--spring.profiles.active=prod`. Do not set `spring.profiles.active` inside a profile-specific file to activate that same profile; pass it at startup or set it in a non-profile-specific source.

Environment variable examples:

```powershell
$env:LEARNING_SERVICE_MAX_ITEMS = "25"
$env:LEARNING_SERVICE_ENVIRONMENT = "local-env-override"
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local
Remove-Item Env:LEARNING_SERVICE_MAX_ITEMS
Remove-Item Env:LEARNING_SERVICE_ENVIRONMENT
```

Command-line override example:

```powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.service.max-items=30
```

The `LearningDiagnosticsController` exposes only selected non-secret values on `/api/v1/config`, and only for `local` or `test`. It deliberately does not dump the whole `Environment`, because environment data can include passwords, tokens and infrastructure details.

## 4. `@ConfigurationProperties` versus `@Value`

Use `@Value` for individual values and SpEL use cases. Use `@ConfigurationProperties` to bind a cohesive, structured settings group with type conversion and validation. `LearningServiceProperties` is a record bound from `learning.service.*`.

- `@ConfigurationPropertiesScan` registers the type.
- `@Validated` turns on validation during property binding.
- `@NotBlank`, `@Min`, and `@Max` reject invalid values.
- Duration strings such as `1s`, `500ms`, and `2s` bind to `Duration`.
- `spring-boot-starter-validation` supplies a Bean Validation implementation.

Try a failing startup:

```powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.service.max-items=0
```

Expected concept: startup fails while binding/validating `LearningServiceProperties`; do not treat any locally observed exact exception wording as a stable API.

## 5. Conditional configuration versus Boot auto-configuration

The app-owned `BannerConfiguration` is ordinary configuration guarded by `@ConditionalOnProperty`. It is not itself Boot auto-configuration. It provides a controlled way to see a condition change.

```powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.banner.enabled=false
```

Compare `/api/v1/greeting` before and after. The application still starts because the dependency is optional via `ObjectProvider`.

Boot auto-configuration is different: Boot imports framework-provided configuration based on conditions such as classes on the classpath, existing bean definitions, application type and properties. Run with `--debug` and read the Condition Evaluation Report. The `conditions` Actuator endpoint is exposed only by the local profile in this lab.

Official reference: https://docs.spring.io/spring-boot/reference/features/developing-auto-configuration.html

## 6. Actuator

The default configuration exposes only `health` and `info` over HTTP. The local profile expands exposure to `metrics`, `conditions`, `configprops`, and `beans` to support learning.

Useful local endpoints:

- `GET /actuator/health`
- `GET /actuator/health/liveness`
- `GET /actuator/health/readiness`
- `GET /actuator/info`
- `GET /actuator/metrics`
- `GET /actuator/metrics/learning.greeting.requests`
- `GET /actuator/conditions`
- `GET /actuator/configprops`
- `GET /actuator/beans`

The custom metric `learning.greeting.requests` increments for each call to the greeting service.

Security rule: do not blindly copy local endpoint exposure into production. Endpoints such as `env`, `configprops`, `beans`, and `conditions` may reveal internal data. Expose only what is necessary and protect management routes with proper network controls and authentication. This learning project does not include Spring Security, so the local profile binds the application to localhost.

Official references:
- https://docs.spring.io/spring-boot/reference/actuator/index.html
- https://docs.spring.io/spring-boot/reference/actuator/endpoints.html
- https://docs.spring.io/spring-boot/reference/actuator/metrics.html

## 7. Observe lifecycle and startup

`StartupLifecycleProbe` logs three milestones:

- `@PostConstruct`: the bean has been instantiated and dependencies have been populated, and the initialization callback is running.
- `ApplicationRunner`: the application context has refreshed and the application runners are being invoked.
- `@PreDestroy`: the managed bean is receiving its destruction callback during graceful context shutdown.

Those markers help separate bean initialization from “application ready” behavior. They do not print secrets or complete bean state.

Commands:

```powershell
mvn spring-boot:run "-Dspring-boot.run.arguments=--spring.profiles.active=local"
```

Then press Ctrl+C and compare log ordering. For a packaged JAR:

```powershell
mvn clean package
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --debug
```

## 8. Test strategy

- `GreetingServiceTest`: plain unit test; no Spring context is started. The test constructs the service directly with a properties record, an empty `ObjectProvider` test double and a simple meter registry.
- `BannerConfigurationTest`: `ApplicationContextRunner` checks the condition with `learning.banner.enabled=true` and `false`.
- `LearningServicePropertiesValidationTest`: validates record constraints directly through Jakarta Bean Validation.
- `GreetingControllerIntegrationTest`: starts a Spring Boot mock web context using the `test` profile and checks endpoint responses and property binding.

Run:

```powershell
mvn clean test
mvn package
```

If a test fails, record the Java/Maven versions and the full first meaningful `Caused by` block before changing code.

## 9. Suggested experiments

1. Compare `/api/v1/config` with the `local` and `test` profiles.
2. Override `learning.service.max-items` using an environment variable and then a command-line argument. Record which value wins.
3. Set `learning.service.max-items=0` and observe property validation failure.
4. Set `learning.banner.enabled=false`; confirm the application starts and the optional banner is absent.
5. Start with `--debug` and identify at least three positive and three negative auto-configuration outcomes.
6. Open `/actuator/conditions` and locate relevant web MVC, Jackson/JSON, and management configuration outcomes.
7. Hit `/api/v1/greeting` several times, then inspect `/actuator/metrics/learning.greeting.requests`.
8. Compare Actuator exposure under `local` and `prod` profiles. Try `/actuator/conditions` under `prod`; it should not be exposed by this application's profile configuration.
9. Stop gracefully and find the `@PreDestroy` lifecycle log.
10. Capture actual outputs in `docs/TEST_RUN_LOG.md`; do not mark a test complete before running it on your machine.

## 10. Trade-offs

Spring Boot increases delivery speed with starters, defaults, auto-configuration and embedded servers. Costs include transitive dependencies, startup work, framework learning curve, conditional configuration complexity, and security risk if operational endpoints are overexposed. The right response is to measure startup/runtime behavior, inspect dependency trees and condition reports, and customize defaults where evidence calls for it.