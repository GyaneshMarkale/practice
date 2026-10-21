# Module 01 — Interview Checkpoint

**Instructions:** Answer from memory before looking up notes. Give (1) the definition, (2) an example, and (3) a trade-off or failure mode. Send your answers in chat for review.

## Fundamentals

1. Define IoC. Define DI. How are they different?
2. What is a Spring bean? Is every Java object automatically a bean?
3. What does the Spring IoC container do?
4. Why is `GreetingService` dependent on `GreetingProvider` rather than `DefaultGreetingProvider`?
5. Walk through the dependency graph from the HTTP endpoint to the provider implementation.

## Injection choices

6. Why is constructor injection usually preferred for required dependencies?
7. When can setter injection be reasonable?
8. What problems can field injection introduce?
9. Why doesn't a class with a single constructor normally need `@Autowired`?
10. How would you test a constructor-injected service without starting Spring?

## Troubleshooting

11. What happens if `DefaultGreetingProvider` is no longer registered as a bean?
12. What happens if two beans implement `GreetingProvider`? How would you fix it?
13. Does adding `@Service` alone guarantee a class is discovered? What else must be true?
14. Explain the difference between `@Component` and `@Bean`.
15. How would you confirm the request really passed through the controller, service and provider?

## Senior-level follow-ups

16. Explain how dependency inversion relates to depending on interfaces. Is an interface mandatory for every injected dependency?
17. What does a constructor with many dependencies often signal?
18. How can circular dependencies arise, and why are constructor-based circular dependencies problematic?
19. What is the difference between creating an object with `new` and having the container manage the object?
20. Describe Spring's high-level startup and dependency-resolution sequence without claiming to know every internal callback.

## Scoring rubric (20 points)

For each answer: 0 = incorrect/no answer; 0.5 = memorized definition only; 0.75 = clear explanation; 1 = correct explanation plus example and trade-off.

- 17–20: strong; proceed to scopes and lifecycle.
- 13–16.5: review weak answers and run experiments again.
- Below 13: revisit Module 01 before moving on.