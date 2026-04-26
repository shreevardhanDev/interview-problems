package com.example.interview_questions;

/**
 * Interview Question 010: Singleton Pattern
 *
 * The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.
 *
 * Example: Thread-safe Singleton using double-checked locking.
 *
 * Explanation: Use volatile and synchronized block for thread safety.
 */
public class InterviewQuestion010_SingletonPattern {
    private static volatile InterviewQuestion010_SingletonPattern instance;

    private InterviewQuestion010_SingletonPattern() {}

    public static InterviewQuestion010_SingletonPattern getInstance() {
        if (instance == null) {
            synchronized (InterviewQuestion010_SingletonPattern.class) {
                if (instance == null) {
                    instance = new InterviewQuestion010_SingletonPattern();
                    instance.showMessage();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance created.");
    }

    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion010_SingletonPattern");
        InterviewQuestion010_SingletonPattern singleton = InterviewQuestion010_SingletonPattern.getInstance();
        singleton = InterviewQuestion010_SingletonPattern.getInstance();
        singleton = InterviewQuestion010_SingletonPattern.getInstance();
        singleton = InterviewQuestion010_SingletonPattern.getInstance();
    }
}