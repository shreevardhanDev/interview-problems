package com.example.interview_questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Practice_Stream2: 23 Employee Stream Operations
 *
 * This file demonstrates 23 different stream operations on employee data,
 * including filtering, grouping, aggregating, and sorting operations.
 *
 * Employee Model:
 * - id: unique identifier
 * - name: employee name
 * - department: department name
 * - salary: annual salary
 */
public class Practice_Stream2 {
    
    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s (%s, $%.2f)", name, department, salary);
        }
    }

    // Sample employee data
    static List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee(1, "Alice", "IT", 8500),
            new Employee(2, "Bob", "HR", 6500),
            new Employee(3, "Charlie", "IT", 9000),
            new Employee(4, "David", "Sales", 7500),
            new Employee(5, "Eve", "IT", 8200),
            new Employee(6, "Frank", "HR", 6800),
            new Employee(7, "Grace", "Sales", 7800),
            new Employee(8, "Henry", "IT", 8800),
            new Employee(9, "Ivy", "Sales", 7200),
            new Employee(10, "Jack", "HR", 7000)
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = getEmployees();
        
        System.out.println("=== 23 Employee Stream Operations ===\n");
        
        // Operation 1: Get All Employees
        operation1_getAllEmployees(employees);
        
        // Operation 2: Filter Salary > 7000
        operation2_filterHighSalary(employees);
        
        // Operation 3: Highest Paid Employee
        operation3_highestPaidEmployee(employees);
        
        // Operation 4: Group by Department
        operation4_groupByDepartment(employees);
        
        // Operation 5: Highest Paid by Department
        operation5_highestPaidByDept(employees);
        
        // Operation 6: Average Salary by Department
        operation6_averageSalaryByDept(employees);
        
        // Operation 7: Employee Count by Department
        operation7_countByDept(employees);
        
        // Operation 8: Sort by Salary Descending
        operation8_sortBySalaryDesc(employees);
        
        // Operation 9: Find 2nd Highest Salary
        operation9_secondHighestSalary(employees);
        
        // Operation 10: Top 3 Highest Paid
        operation10_topThreeHighestPaid(employees);
        
        // Operation 11: Partition by Salary Threshold
        operation11_partitionBySalary(employees);
        
        // Operation 12: Join Names into String
        operation12_joinNames(employees);
        
        // Operation 13: Department with Max Avg Salary
        operation13_deptMaxAvgSalary(employees);
        
        // Operation 14: Names Starting with E
        operation14_namesStartingWithE(employees);
        
        // Operation 15: Distinct Departments
        operation15_distinctDepartments(employees);
        
        // Operation 16: Group by Department, Sort by Salary
        operation16_groupAndSort(employees);
        
        // Operation 17: Min Salary per Department
        operation17_minSalaryPerDept(employees);
        
        // Operation 18: Total Salary Sum
        operation18_totalSalarySum(employees);
        
        // Operation 19: Salary Range (Min-Max)
        operation19_salaryRange(employees);
        
        // Operation 20: Count Employees with Salary > 8000
        operation20_countHighSalary(employees);
        
        // Operation 21: Any Employee in IT with Salary > 9000
        operation21_anyHighPaidIT(employees);
        
        // Operation 22: All Employees in HR
        operation22_allInHR(employees);
        
        // Operation 23: Map to Names Only
        operation23_mapToNamesOnly(employees);
    }

    // 1. Get All Employees
    static void operation1_getAllEmployees(List<Employee> employees) {
        System.out.println("1. Get All Employees:");
        employees.stream().forEach(e -> System.out.println("   " + e));
        System.out.println();
    }

    // 2. Filter Salary > 7000
    static void operation2_filterHighSalary(List<Employee> employees) {
        System.out.println("2. Filter Salary > 7000:");
        employees.stream()
            .filter(e -> e.salary > 7000)
            .forEach(e -> System.out.println("   " + e));
        System.out.println();
    }

    // 3. Highest Paid Employee
    static void operation3_highestPaidEmployee(List<Employee> employees) {
        System.out.println("3. Highest Paid Employee:");
        employees.stream()
            .max(Comparator.comparingDouble(e -> e.salary))
            .ifPresent(e -> System.out.println("   " + e));
        System.out.println();
    }

    // 4. Group by Department
    static void operation4_groupByDepartment(List<Employee> employees) {
        System.out.println("4. Group by Department:");
        Map<String, List<Employee>> grouped = employees.stream()
            .collect(Collectors.groupingBy(e -> e.department));
        grouped.forEach((dept, emps) -> {
            System.out.println("   " + dept + ":");
            emps.forEach(e -> System.out.println("      " + e));
        });
        System.out.println();
    }

    // 5. Highest Paid by Department
    static void operation5_highestPaidByDept(List<Employee> employees) {
        System.out.println("5. Highest Paid by Department:");
        Map<String, Optional<Employee>> result = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.maxBy(Comparator.comparingDouble(e -> e.salary))
            ));
        result.forEach((dept, emp) -> {
            if (emp.isPresent()) {
                System.out.println("   " + dept + ": " + emp.get());
            }
        });
        System.out.println();
    }

    // 6. Average Salary by Department
    static void operation6_averageSalaryByDept(List<Employee> employees) {
        System.out.println("6. Average Salary by Department:");
        Map<String, Double> avgSalaries = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.averagingDouble(e -> e.salary)
            ));
        avgSalaries.forEach((dept, avg) -> 
            System.out.println("   " + dept + ": $" + String.format("%.2f", avg))
        );
        System.out.println();
    }

    // 7. Employee Count by Department
    static void operation7_countByDept(List<Employee> employees) {
        System.out.println("7. Employee Count by Department:");
        Map<String, Long> counts = employees.stream()
            .collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
        counts.forEach((dept, count) -> 
            System.out.println("   " + dept + ": " + count + " employees")
        );
        System.out.println();
    }

    // 8. Sort by Salary Descending
    static void operation8_sortBySalaryDesc(List<Employee> employees) {
        System.out.println("8. Sort by Salary Descending:");
        employees.stream()
            .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
            .forEach(e -> System.out.println("   " + e));
        System.out.println();
    }

    // 9. Find 2nd Highest Salary
    static void operation9_secondHighestSalary(List<Employee> employees) {
        System.out.println("9. Find 2nd Highest Salary:");
        employees.stream()
            .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
            .skip(1)
            .findFirst()
            .ifPresent(e -> System.out.println("   " + e));
        System.out.println();
    }

    // 10. Top 3 Highest Paid
    static void operation10_topThreeHighestPaid(List<Employee> employees) {
        System.out.println("10. Top 3 Highest Paid:");
        employees.stream()
            .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
            .limit(3)
            .forEach(e -> System.out.println("    " + e));
        System.out.println();
    }

    // 11. Partition by Salary Threshold
    static void operation11_partitionBySalary(List<Employee> employees) {
        System.out.println("11. Partition by Salary Threshold (7500):");
        Map<Boolean, List<Employee>> partitioned = employees.stream()
            .collect(Collectors.partitioningBy(e -> e.salary >= 7500));
        System.out.println("   High Earners (>= 7500):");
        partitioned.get(true).forEach(e -> System.out.println("      " + e));
        System.out.println("   Low Earners (< 7500):");
        partitioned.get(false).forEach(e -> System.out.println("      " + e));
        System.out.println();
    }

    // 12. Join Names into String
    static void operation12_joinNames(List<Employee> employees) {
        System.out.println("12. Join Names into String:");
        String names = employees.stream()
            .map(e -> e.name)
            .collect(Collectors.joining(", "));
        System.out.println("    " + names);
        System.out.println();
    }

    // 13. Department with Max Avg Salary
    static void operation13_deptMaxAvgSalary(List<Employee> employees) {
        System.out.println("13. Department with Max Average Salary:");
        String deptWithMaxAvg = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.averagingDouble(e -> e.salary)
            ))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("Unknown");
        System.out.println("    " + deptWithMaxAvg);
        System.out.println();
    }

    // 14. Names Starting with E
    static void operation14_namesStartingWithE(List<Employee> employees) {
        System.out.println("14. Names Starting with E:");
        employees.stream()
            .filter(e -> e.name.startsWith("E"))
            .forEach(e -> System.out.println("    " + e));
        System.out.println();
    }

    // 15. Distinct Departments
    static void operation15_distinctDepartments(List<Employee> employees) {
        System.out.println("15. Distinct Departments:");
        employees.stream()
            .map(e -> e.department)
            .distinct()
            .forEach(dept -> System.out.println("    " + dept));
        System.out.println();
    }

    // 16. Group by Department, Sort by Salary
    static void operation16_groupAndSort(List<Employee> employees) {
        System.out.println("16. Group by Department, Sort by Salary:");
        Map<String, List<Employee>> grouped = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> list.stream()
                        .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
                        .collect(Collectors.toList())
                )
            ));
        grouped.forEach((dept, emps) -> {
            System.out.println("    " + dept + ":");
            emps.forEach(e -> System.out.println("       " + e));
        });
        System.out.println();
    }

    // 17. Min Salary per Department
    static void operation17_minSalaryPerDept(List<Employee> employees) {
        System.out.println("17. Min Salary per Department:");
        Map<String, Optional<Employee>> result = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.minBy(Comparator.comparingDouble(e -> e.salary))
            ));
        result.forEach((dept, emp) -> {
            emp.ifPresent(employee -> System.out.println("    " + dept + ": " + employee));
        });
        System.out.println();
    }

    // 18. Total Salary Sum
    static void operation18_totalSalarySum(List<Employee> employees) {
        System.out.println("18. Total Salary Sum:");
        double totalSalary = employees.stream().mapToDouble(e -> e.salary).sum();
        System.out.println("    $" + String.format("%.2f", totalSalary));
        System.out.println();
    }

    // 19. Salary Range (Min-Max)
    static void operation19_salaryRange(List<Employee> employees) {
        System.out.println("19. Salary Range:");
        DoubleSummaryStatistics stats = employees.stream()
            .collect(Collectors.summarizingDouble(e -> e.salary));
        System.out.println("    Min: $" + String.format("%.2f", stats.getMin()));
        System.out.println("    Max: $" + String.format("%.2f", stats.getMax()));
        System.out.println("    Avg: $" + String.format("%.2f", stats.getAverage()));
        System.out.println();
    }

    // 20. Count Employees with Salary > 8000
    static void operation20_countHighSalary(List<Employee> employees) {
        System.out.println("20. Count Employees with Salary > 8000:");
        long count = employees.stream()
            .filter(e -> e.salary > 8000)
            .count();
        System.out.println("    " + count + " employees");
        System.out.println();
    }

    // 21. Any Employee in IT with Salary > 9000
    static void operation21_anyHighPaidIT(List<Employee> employees) {
        System.out.println("21. Any Employee in IT with Salary > 9000:");
        boolean exists = employees.stream()
            .anyMatch(e -> "IT".equals(e.department) && e.salary > 9000);
        System.out.println("    " + (exists ? "Yes" : "No"));
        System.out.println();
    }

    // 22. All Employees in HR
    static void operation22_allInHR(List<Employee> employees) {
        System.out.println("22. All Employees in HR:");
        boolean allInHR = employees.stream()
            .allMatch(e -> "HR".equals(e.department));
        System.out.println("    " + (allInHR ? "Yes" : "No"));
        System.out.println();
    }

    // 23. Map to Names Only
    static void operation23_mapToNamesOnly(List<Employee> employees) {
        System.out.println("23. Map to Names Only:");
        List<String> names = employees.stream()
            .map(e -> e.name)
            .toList();
        System.out.println("    " + names);
        System.out.println();
    }
}
