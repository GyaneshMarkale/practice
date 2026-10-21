# Review This First — Spring Boot Foundations

This project is published at `https://github.com/GyaneshMarkale/practice/tree/main/spring-boot-foundations`. Review the code and run the tests locally before treating it as verified; Maven tests have not yet been executed in the preparation environment.

Read in this order:

1. `README.md` — how the service runs and which files matter.
2. `docs/PROJECT_REVIEW_BEFORE_GITHUB.md` — architecture, dependency rationale, security and review checklist.
3. `docs/MODULE_02_LEARNING_NOTES.md` — concepts taught by the code.
4. `docs/CONFIGURATION_AND_PROFILES_LAB.md` — hands-on configuration tests.
5. `docs/ACTUATOR_PRODUCTION_READINESS.md` — endpoint usage and security boundaries.
6. `docs/STARTUP_AND_AUTOCONFIGURATION_LAB.md` — startup logs and conditions.
7. `docs/INTERVIEW_QUESTIONS_MODULE_02.md` — self-test.
8. `docs/TEST_RUN_LOG.md` — paste real test/run output here after testing.

Then run `mvn clean test`, start the app locally, inspect the outputs, and decide whether any changes are needed. Commit review fixes to the same project folder.

Important verification note: the files were generated and statically inspected in the preparation environment. Maven is not installed in that environment, so the Maven tests have not been executed there. The project must be built and tested on a machine with JDK 21, Maven, and dependency-repository access before we call it verified.