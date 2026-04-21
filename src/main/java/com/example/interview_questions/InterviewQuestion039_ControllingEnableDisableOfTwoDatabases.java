package com.example.interview_questions;

/**
 * Interview Question 039: Controlling Enable/Disable of Two Databases
 *
 * In Spring, use @ConditionalOnProperty to enable/disable beans.
 * For multiple databases, configure DataSources conditionally.
 *
 * Explanation: Use profiles or properties to control.
 *
 * Example: Conditional bean.
 */
public class InterviewQuestion039_ControllingEnableDisableOfTwoDatabases {
    // @Bean
    // @ConditionalOnProperty(name = "db.primary.enabled", havingValue = "true")
    // public DataSource primaryDataSource() {
    //     return DataSourceBuilder.create().build();
    // }

    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion039_ControllingEnableDisableOfTwoDatabases");
        System.out.println("See the commented code for example.");
    }
}