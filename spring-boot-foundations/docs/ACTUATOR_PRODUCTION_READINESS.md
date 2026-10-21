# Lab — Actuator and Production Readiness

## What this project exposes

By default (\`application.yaml\`), only \`health\` and \`info\` are exposed over HTTP. The \`local\` profile adds \`metrics\`, \`conditions\`, \`configprops\`, and \`beans\` strictly to support hands-on diagnosis. The \`prod\` profile returns to minimal \`health,info\` exposure.

## Check local endpoints

Activate \`local\` and visit:

- \`http://localhost:8080/actuator/health\`
- \`http://localhost:8080/actuator/health/liveness\`
- \`http://localhost:8080/actuator/health/readiness\`
- \`http://localhost:8080/actuator/info\`
- \`http://localhost:8080/actuator/metrics\`
- \`http://localhost:8080/actuator/metrics/learning.greeting.requests\`
- \`http://localhost:8080/actuator/conditions\`
- \`http://localhost:8080/actuator/configprops\`
- \`http://localhost:8080/actuator/beans\`

Call \`/api/v1/greeting\` a few times before checking the custom counter.

## What they mean

- **Health:** status from the application's configured health contributors. A healthy response does not prove that latency is acceptable.
- **Liveness:** should this process continue running, or is it irrecoverably broken?
- **Readiness:** should this instance receive new traffic now?
- **Info:** application metadata useful to operators and deployment tooling.
- **Metrics:** instrumented measurements, such as JVM metrics and custom counters.
- **Conditions:** which auto-configurations matched or backed off.
- **Config properties:** bound settings; may disclose operational values depending on endpoint settings.
- **Beans:** bean names and types; helpful for learning, but provides an internal map of the app.

## Production checklist

- Expose only endpoints operators actually need.
- Put management endpoints behind authentication and network policy where required.
- Never expose environment dumps or secrets in diagnostic HTTP endpoints.
- Configure real readiness/liveness policy for the deployment platform.
- Use metrics/alerts to detect latency, error rates, resource pressure, and dependency failures; don't depend on a simple UP response alone.
- Verify actuator behavior with the same Spring Boot version and deployment topology that will run in production.
- Keep local-only diagnostic controllers and profiles out of a production package if the application's threat model requires a stronger separation.

This lab does not add Spring Security deliberately, so it should stay bound to localhost under the \`local\` profile. A real production service must implement the security and network access policy appropriate to its deployment.

Official references:
- https://docs.spring.io/spring-boot/reference/actuator/index.html
- https://docs.spring.io/spring-boot/reference/actuator/endpoints.html
- https://docs.spring.io/spring-boot/reference/actuator/metrics.html
