# Lab — Startup, Bean Creation and Auto-Configuration

## Part A: Observe startup

Start the application with the local profile and the condition report:

\`\`\`powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --debug
\`\`\`

Find the custom log lines:

- \`[learning-lifecycle] ... @PostConstruct completed\`
- \`[learning-lifecycle] ApplicationRunner executed ...\`

Stop with Ctrl+C and look for the \`@PreDestroy\` line.

### Optional detailed bean creation logs

\`\`\`powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --logging.level.org.springframework.beans.factory.support=DEBUG
\`\`\`

Use the focused logger rather than starting with all Spring internals at TRACE, which can create too much output.

## Part B: Auto-configuration report

\`--debug\` asks Boot to log the condition evaluation report. Find the positive and negative sections. Search within output for MVC, Jackson/JSON serialization, servlet server, Actuator and metrics terms.

For every condition you select, record:

- Configuration class name.
- What condition matched or did not match.
- Relevant classpath, property, or bean that influenced it.
- What changed when you overrode a default or changed the profile.

## Part C: Compare the banner condition

With banner enabled:

\`\`\`powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.banner.enabled=true
\`\`\`

With banner disabled:

\`\`\`powershell
java -jar target/spring-boot-foundations-0.1.0-SNAPSHOT.jar --spring.profiles.active=local --learning.banner.enabled=false
\`\`\`

Compare \`bannerEnabled\` and \`bannerMessage\` in \`/api/v1/greeting\`. The service continues running because \`ObjectProvider<LearningBanner>\` makes the dependency optional.

This is **application-owned conditional configuration**, not Boot's own auto-configuration. Use \`/actuator/conditions\` to inspect Boot's report for the latter.

## Part D: Observe beans

Under \`local\`, inspect \`/actuator/beans\`. Search for \`greetingService\`, \`greetingController\`, \`learningServiceProperties\`, and \`learningBanner\`. Compare with the condition behavior when \`learning.banner.enabled=false\`.

## Part E: Understand the sequence

A useful high-level model is:

1. \`main()\` calls \`SpringApplication.run(...)\`.
2. Boot prepares the environment and creates/configures the appropriate application context.
3. Bean definitions are registered through component scanning, explicit configuration and auto-configuration.
4. The context is refreshed; non-lazy singleton beans and their dependencies are created and initialized.
5. The embedded web server is started as part of the web application startup process.
6. Application runners execute after context refresh.
7. When the context closes gracefully, managed singleton destruction callbacks run.

This is a mental model, not a precise exhaustive call stack. Startup ordering can vary with application type, configuration, lazy initialization, and framework version.

Official reference: https://docs.spring.io/spring-boot/how-to/application.html
