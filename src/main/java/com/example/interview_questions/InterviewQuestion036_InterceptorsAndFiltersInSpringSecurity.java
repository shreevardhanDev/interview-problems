package com.example.interview_questions;

/**
 * Interview Question 036: Interceptors and Filters in Spring Security
 *
 * Filters: Part of Servlet API, intercept requests before they reach the controller.
 * Interceptors: Spring-specific, intercept after filters but before controller.
 * In Spring Security, filters like UsernamePasswordAuthenticationFilter handle authentication.
 *
 * Explanation: Filters for low-level, interceptors for application logic.
 *
 * Example: A simple filter implementation.
 */
public class InterviewQuestion036_InterceptorsAndFiltersInSpringSecurity {
    // Example Filter (in Spring, implement Filter interface)
    // public class MyFilter implements Filter {
    //     @Override
    //     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    //         System.out.println("Filter: Request intercepted");
    //         chain.doFilter(request, response);
    //     }
    // }

    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion036_InterceptorsAndFiltersInSpringSecurity");
        System.out.println("See the commented code for example.");
    }
}