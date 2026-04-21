package com.example.interview_questions;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Interview Question 038: Rate Limiter Implementation
 *
 * A simple rate limiter using token bucket or sliding window.
 * Here, fixed window with count.
 *
 * Explanation: Track requests per user per time window.
 */
public class InterviewQuestion038_RateLimiterImplementation {
    private final ConcurrentHashMap<String, AtomicInteger> requestCount = new ConcurrentHashMap<>();
    private final int maxRequests = 10;
    private final long windowMillis = 60000; // 1 min

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        // For simplicity, assume reset every window, but in real, use timestamps.
        AtomicInteger count = requestCount.computeIfAbsent(userId, k -> new AtomicInteger(0));
        if (count.get() < maxRequests) {
            count.incrementAndGet();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion038_RateLimiterImplementation");
        InterviewQuestion038_RateLimiterImplementation limiter = new InterviewQuestion038_RateLimiterImplementation();
        System.out.println(limiter.allowRequest("user1")); // true
    }
}