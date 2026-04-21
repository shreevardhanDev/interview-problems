package com.example.interview_questions;

/**
 * Interview Question 033: Static Synchronized in Singleton
 *
 * In Singleton pattern, to make getInstance() thread-safe, use synchronized keyword.
 * Static synchronized locks on the class object.
 *
 * Example: public static synchronized Singleton getInstance() { ... }
 *
 * Explanation: Ensures only one thread can access at a time.
 */
public class InterviewQuestion033_StaticSynchronizedInSingleton {
    private static InterviewQuestion033_StaticSynchronizedInSingleton instance;

    private InterviewQuestion033_StaticSynchronizedInSingleton() {}

    public static synchronized InterviewQuestion033_StaticSynchronizedInSingleton getInstance() {
        if (instance == null) {
            instance = new InterviewQuestion033_StaticSynchronizedInSingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance created using static synchronized.");
    }

    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion033_StaticSynchronizedInSingleton");
        InterviewQuestion033_StaticSynchronizedInSingleton singleton = InterviewQuestion033_StaticSynchronizedInSingleton.getInstance();
        singleton.showMessage();
    }
}