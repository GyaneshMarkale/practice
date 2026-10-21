# Spring Boot Foundations — Practical Learning Project

A step-by-step Spring Boot learning project for Java backend and SDE-II/SDE-III interviews. It begins with IoC/DI study notes and adds a runnable service for configuration, profiles, validation, Actuator, startup analysis and conditional configuration.

> **Review status:** this project has been created locally for review. It has not been pushed to GitHub. The current preparation container has Java 21 but no Maven installation and no access to dependency repositories, so the Maven build/tests have not been executed here. Run the commands below on a Maven-enabled machine and record the actual output before publishing.

## Version

- Java 21
- Spring Boot 4.1.1
- Maven 3.6.3+ (3.9+ recommended)

Boot 4.1.1's official system requirements specify Java 17+ and Maven 3.6.3+; this project uses Java 21. Boot 4's modular starter names are used, including `spring-boot-starter-webmvc` and `spring-boot-starter-webmvc-test`.

## Start here

Read [`REVIEW_THIS_FIRST.md`](REVIEW_THIS_FIRST.md), then `docs/PROJECT_REVIEW_BEFORE_GITHUB.md`.

## Run on Windows PowerShell

Requirements: a JDK 21 distribution, Maven, and access to Maven Central or your configured Maven repository.

```powershell
java -version
mvn -version
mvn clean test
mvn package
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local
```

Keep the process running and open another PowerShell window:

```powershell
Invoke-RestMethod "http://localhost:8080/api/v1/greeting?name=Gyanesh" | ConvertTo-Json -Depth 5
Invoke-RestMethod "http://localhost:8080/api/v1/config" | ConvertTo-Json -Depth 5
Invoke-RestMethod "http://localhost:8080/actuator/health" | ConvertTo-Json -Depth 5
Invoke-RestMethod "http://localhost:8080/actuator/info" | ConvertTo-Json -Depth 5
Invoke-RestMethod "http://localhost:8080/actuator/metrics/learning.greeting.requests" | ConvertTo-Json -Depth 5
```

The local profile binds the server to `127.0.0.1`, so these learning endpoints are intended for local use.

## Main endpoints

| Endpoint | Purpose | Availability |
|---|---|---|
| `GET /api/v1/greeting?name=Gyanesh` | Constructor injection, configuration binding and custom request counter | All profiles |
| `GET /api/v1/config` | Shows a small allowlist of resolved settings | `local` and `test` only |
| `GET /actuator/health` | Application health | Default exposure |
| `GET /actuator/health/liveness` | Liveness probe | Health probes enabled |
| `GET /actuator/health/readiness` | Readiness probe | Health probes enabled |
| `GET /actuator/info` | Safe application metadata | Default exposure |
| `GET /actuator/metrics` | Metrics index | `local` profile exposure |
| `GET /actuator/metrics/learning.greeting.requests` | Custom greeting counter | `local` profile exposure |
| `GET /actuator/conditions` | Auto-configuration condition report | `local` profile exposure |
| `GET /actuator/beans` | Registered bean metadata | `local` profile exposure |
| `GET /actuator/configprops` | Bound configuration properties metadata | `local` profile exposure |

Never expose all these management endpoints to the internet without a deliberate security review. The `local` profile binds to loopback. The sample `prod` profile has minimal Actuator exposure, but this learning application does not implement Spring Security; production deployment needs an appropriate management security and network policy.

## Run profiles and overrides

```powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=test
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=prod
```

Override a property from the command line:

```powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.service.max-items=30
```

Test validation failure (max items must be 1–100):

```powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.service.max-items=0
```

Inspect Boot auto-configuration decisions:

```powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --debug
```

Disable the optional demo banner bean:

```powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.banner.enabled=false
```

## Learning documents

- [`MODULE_01_IOC_DI.md`](MODULE_01_IOC_DI.md) — IoC and dependency injection.
- [`INTERVIEW_QUESTIONS_MODULE_01.md`](INTERVIEW_QUESTIONS_MODULE_01.md) — Module 1 checkpoint questions.
- [`docs/MODULE_02_LEARNING_NOTES.md`](docs/MODULE_02_LEARNING_NOTES.md) — project architecture and concepts.
- [`docs/CONFIGURATION_AND_PROFILES_LAB.md`](docs/CONFIGURATION_AND_PROFILES_LAB.md) — configuration experiments.
- [`docs/ACTUATOR_PRODUCTION_READINESS.md`](docs/ACTUATOR_PRODUCTION_READINESS.md) — Actuator and operational risks.
- [`docs/STARTUP_AND_AUTOCONFIGURATION_LAB.md`](docs/STARTUP_AND_AUTOCONFIGURATION_LAB.md) — startup and condition reports.
- [`docs/INTERVIEW_QUESTIONS_MODULE_02.md`](docs/INTERVIEW_QUESTIONS_MODULE_02.md) — interview practice.
- [`docs/PROJECT_REVIEW_BEFORE_GITHUB.md`](docs/PROJECT_REVIEW_BEFORE_GITHUB.md) — file-by-file review and publication checklist.
- [`docs/TEST_RUN_LOG.md`](docs/TEST_RUN_LOG.md) — record the actual build/test outputs.

## Suggested learning sequence

1. Read Module 1 notes on IoC/DI, then browse the project source and trace constructor dependencies.
2. Run the service under `local` and `test`; compare effective settings.
3. Run an invalid-property startup and explain the validation exception.
4. Toggle the conditional banner bean and observe the difference.
5. Inspect Actuator endpoints and compare their exposure between `local` and `prod`.
6. Run with `--debug` and document at least three positive and three negative auto-configuration outcomes.
7. Run tests, record real results, review all files, and only then decide about GitHub publication.

## Official references

- [Spring Boot system requirements](https://docs.spring.io/spring-boot/system-requirements.html)
- [Starters and dependency management](https://docs.spring.io/spring-boot/reference/using/build-systems.html)
- [Externalized configuration](https://docs.spring.io/spring-boot/reference/features/external-config.html)
- [Profiles](https://docs.spring.io/spring-boot/reference/features/profiles.html)
- [Auto-configuration](https://docs.spring.io/spring-boot/reference/features/developing-auto-configuration.html)
- [Actuator endpoints](https://docs.spring.io/spring-boot/reference/actuator/endpoints.html)
- [Metrics](https://docs.spring.io/spring-boot/reference/actuator/metrics.html)