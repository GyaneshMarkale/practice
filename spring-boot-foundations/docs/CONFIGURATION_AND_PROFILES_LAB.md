# Lab — External Configuration, Profiles and Validation

## Goals

- Explain why configuration should not be hard-coded in service logic.
- Distinguish application defaults, profile-specific overrides, environment variables, and command-line overrides.
- Bind a property group to a type-safe record using \`@ConfigurationProperties\`.
- Validate configuration and diagnose a startup failure.

## Experiment A: local profile

\`\`\`powershell
mvn clean package
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local
\`\`\`

Call \`/api/v1/config\`. Expected profile-specific concepts: configured environment is \`local\`, max items is \`10\`, request timeout is \`PT1S\`, and the active profile list contains \`local\`.

## Experiment B: test profile

\`\`\`powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=test
\`\`\`

The diagnostic controller is also available in \`test\` so the same API can show that profile-specific values changed without recompiling Java.

## Experiment C: environment variables

In a fresh PowerShell window:

\`\`\`powershell
$env:LEARNING_SERVICE_MAX_ITEMS = "25"
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local
\`\`\`

Inspect \`/api/v1/config\`; the environment variable overrides the local YAML value. Clean up after the experiment:

\`\`\`powershell
Remove-Item Env:LEARNING_SERVICE_MAX_ITEMS
\`\`\`

## Experiment D: command-line precedence

\`\`\`powershell
$env:LEARNING_SERVICE_MAX_ITEMS = "25"
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.service.max-items=30
\`\`\`

Expected \`maxItems\`: 30. Then remove the environment variable.

## Experiment E: invalid configuration

\`\`\`powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.service.max-items=0
\`\`\`

Expected behavior: the application fails to start with a validation/binding error because the configured minimum is 1. Record the actual top-level exception and root cause in \`TEST_RUN_LOG.md\`.

## Questions

1. Why is the same packaged JAR able to behave differently across profiles?
2. Why prefer \`@ConfigurationProperties\` for a group of related settings?
3. What would go wrong if a secret were returned by the \`/api/v1/config\` endpoint?
4. What is the distinction between a missing property and an invalid property?
5. Which property sources can override YAML values, and how would you prove the actual value at runtime?
