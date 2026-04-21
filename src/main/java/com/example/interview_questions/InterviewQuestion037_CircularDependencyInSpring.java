package com.example.interview_questions;

/**
 * Interview Question 037: Circular Dependency in Spring
 *
 * Circular dependency occurs when two or more beans depend on each other.
 * Spring throws BeanCurrentlyInCreationException.
 * Solutions: Use @Lazy, setter injection, or redesign.
 *
 * Explanation: Avoid by proper design.
 *
 * Example: Two beans depending on each other.
 */
public class InterviewQuestion037_CircularDependencyInSpring {
    // @Component
    // public class A {
    //     @Autowired
    //     private B b;
    // }

    // @Component
    // public class B {
    //     @Autowired
    //     private A a;
    // }

    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion037_CircularDependencyInSpring");
        System.out.println("See the commented code for example.");
    }
}