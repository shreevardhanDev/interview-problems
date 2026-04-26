package com.example.interview_questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Interview Question 034: Internal Working of Executor Framework
 *
 * The Executor framework in Java provides a way to execute tasks asynchronously.
 * Key components: Executor, ExecutorService, ThreadPoolExecutor.
 * ThreadPoolExecutor manages a pool of threads, a queue for tasks, and executes them.
 * When a task is submitted, it's added to the queue if threads are busy.
 *
 * Explanation: Decouples task submission from execution.
 */
public class InterviewQuestion034_InternalWorkingOfExecutorFramework {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion034_InternalWorkingOfExecutorFramework");
        try(ExecutorService executor = Executors.newFixedThreadPool(2)){
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println("Task executed by " + Thread.currentThread().getName());
            });
        }
        }
    }
}