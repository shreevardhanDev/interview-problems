package com.example.interview_questions;

import java.util.concurrent.CompletableFuture;

/**
 * Interview Question 046: CompletableFuture for Asynchronous User Processing
 *
 * Use CompletableFuture to process users asynchronously.
 *
 * Example: Process a list of users in parallel.
 */
public class InterviewQuestion046_CompletableFutureAsynchronousUserProcessing {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion046_CompletableFutureAsynchronousUserProcessing");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "User processed");
        future.thenAccept(System.out::println);
        // Wait for completion
        future.join();
    }
}