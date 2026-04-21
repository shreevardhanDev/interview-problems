package com.example.interview_questions;

// import javax.persistence.*;
// import java.util.Set;

/**
 * Interview Question 012: JPA Many-to-Many Relationship Between Student and Course
 *
 * In JPA, many-to-many relationships are modeled using @ManyToMany annotation.
 *
 * Example entities for Student and Course.
 *
 * Explanation: Use @ManyToMany with @JoinTable for the join table.
 */

// @Entity
// public class Student {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//
//     @ManyToMany
//     @JoinTable(
//         name = "student_course",
//         joinColumns = @JoinColumn(name = "student_id"),
//         inverseJoinColumns = @JoinColumn(name = "course_id")
//     )
//     private Set<Course> courses;
// }

// @Entity
// public class Course {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String title;
//
//     @ManyToMany(mappedBy = "courses")
//     private Set<Student> students;
// }

public class InterviewQuestion012_JPAManyToManyRelationship {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion012_JPAManyToManyRelationship");
        System.out.println("See the commented code for JPA entities.");
        // In a real app, use EntityManager to persist.
    }
}