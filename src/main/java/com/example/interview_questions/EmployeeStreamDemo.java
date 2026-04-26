package com.example.interview_questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * EmployeeStreamDemo: 6 Essential Employee Stream Operations
 *
 * Demonstrates common stream operations on employee objects:
 * 1. Uppercase Employee Names
 * 2. Total Salary Sum
 * 3. Unique Project Names (FlatMap)
 * 4. Names Grouped by Department
 * 5. Nth Highest Salary
 * 6. Partition High/Low Earners
 */
public class EmployeeStreamDemo {
    
    static class Employee {
        int id;
        String name;
        String department;
        double salary;
        List<String> projects;

        Employee(int id, String name, String department, double salary, List<String> projects) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.projects = projects;
        }

        @Override
        public String toString() {
            return String.format("%-10s (%-7s, $%.2f)", name, department, salary);
        }
    }

    static List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee(1, "Alice", "IT", 8500, Arrays.asList("Project A", "Project B")),
            new Employee(2, "Bob", "HR", 6500, Arrays.asList("Project C")),
            new Employee(3, "Charlie", "IT", 9000, Arrays.asList("Project A", "Project D")),
            new Employee(4, "David", "Sales", 7500, Arrays.asList("Project E")),
            new Employee(5, "Eve", "IT", 8200, Arrays.asList("Project B", "Project F")),
            new Employee(6, "Frank", "HR", 6800, Arrays.asList("Project C", "Project G")),
            new Employee(7, "Grace", "Sales", 7800, Arrays.asList("Project E", "Project H")),
            new Employee(8, "Henry", "IT", 8800, Arrays.asList("Project A"))
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = getEmployees();
        
        System.out.println("=== 6 Essential Employee Stream Operations ===\n");
        
        operation1_uppercaseNames(employees);
        operation2_totalSalarySum(employees);
        operation3_uniqueProjects(employees);
        operation4_namesByDepartment(employees);
        operation5_nthHighestSalary(employees, 3);
        operation6_partitionHighLow(employees);
    }

    // 1. Uppercase Employee Names
    static void operation1_uppercaseNames(List<Employee> employees) {
        System.out.println("1. Uppercase Employee Names:");
        List<String> uppercaseNames = employees.stream()
            .map(e -> e.name.toUpperCase())
            .toList();
        uppercaseNames.forEach(name -> System.out.println("   " + name));
        System.out.println();
    }

    // 2. Total Salary Sum
    static void operation2_totalSalarySum(List<Employee> employees) {
        System.out.println("2. Total Salary Sum:");
        double totalSalary = employees.stream().mapToDouble(e -> e.salary).sum();
        System.out.println("   Total: $" + String.format("%.2f", totalSalary));
        System.out.println();
    }

    // 3. Unique Project Names (FlatMap)
    static void operation3_uniqueProjects(List<Employee> employees) {
        System.out.println("3. Unique Project Names (FlatMap):");
        Set<String> uniqueProjects = employees.stream()
            .flatMap(e -> e.projects.stream())
            .collect(Collectors.toSet());
        uniqueProjects.forEach(project -> System.out.println("   " + project));
        System.out.println();
    }

    // 4. Names Grouped by Department
    static void operation4_namesByDepartment(List<Employee> employees) {
        System.out.println("4. Names Grouped by Department:");
        Map<String, List<String>> namesByDept = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.mapping(e -> e.name, Collectors.toList())
            ));
        namesByDept.forEach((dept, names) -> {
            System.out.println("   " + dept + ": " + names);
        });
        System.out.println();
    }

    // 5. Nth Highest Salary (find nth employee by salary)
    static void operation5_nthHighestSalary(List<Employee> employees, int n) {
        System.out.println("5. " + n + "rd Highest Salary Employee:");
        employees.stream()
            .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
            .skip(n - 1)
            .findFirst()
            .ifPresent(e -> System.out.println("   " + e));
        System.out.println();
    }

    // 6. Partition High/Low Earners
    static void operation6_partitionHighLow(List<Employee> employees) {
        System.out.println("6. Partition High/Low Earners (threshold: $8000):");
        Map<Boolean, List<Employee>> partitioned = employees.stream()
            .collect(Collectors.partitioningBy(e -> e.salary >= 8000));
        
        System.out.println("   High Earners (>= $8000):");
        partitioned.get(true).forEach(e -> System.out.println("      " + e));
        
        System.out.println("   Low Earners (< $8000):");
        partitioned.get(false).forEach(e -> System.out.println("      " + e));
        System.out.println();
    }
}
