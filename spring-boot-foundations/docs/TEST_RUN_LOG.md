# Test Run Log

Use this file to record actual test and runtime evidence. The project is published; keep this log updated before describing the project as verified.

## Environment

- Date:
- Operating system:
- `java -version` output:
- `mvn -version` output:
- Active profile:

## Build and test

Command: `mvn clean test`

Actual summary:

```text
Paste the real Maven summary here.
```

Result: [ ] Passed [ ] Failed [ ] Not run

## Package

Command: `mvn package`

Actual output / JAR path:

```text
Paste actual output here.
```

Result: [ ] Passed [ ] Failed [ ] Not run

## Local profile and endpoints

- [ ] `GET /api/v1/greeting?name=Gyanesh`
- [ ] `GET /api/v1/config` (only local/test profile)
- [ ] `GET /actuator/health`
- [ ] `GET /actuator/info`
- [ ] `GET /actuator/metrics/learning.greeting.requests`
- [ ] `GET /actuator/conditions`
- [ ] `GET /actuator/beans`

Paste actual outputs or a concise summary below:

```text
Not run yet.
```

## Negative tests and condition comparisons

- [ ] `--learning.service.max-items=0` fails validation.
- [ ] `--learning.banner.enabled=false` omits the optional banner bean.
- [ ] `--spring.profiles.active=prod` avoids local diagnostic controller and extra actuator exposure.
- [ ] Environment and command-line overrides are compared.
- [ ] `--debug` report inspected and at least 3 positive / 3 negative matches recorded.
- [ ] Graceful shutdown logs the `@PreDestroy` callback.

Findings:

```text
Not run yet.
```