package com.example.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Problem 085: Course Schedule
 *
 * Determine if all courses can be finished given prerequisites.
 *
 * Approach: Topological Sort (Kahn's Algorithm)
 * - Build directed graph: prereq -> course
 * - Track in-degree (number of prerequisites) for each course
 * - Process courses with 0 prerequisites (no dependencies)
 * - If all courses processed, cycle-free (valid schedule) exists
 * - Time: O(V + E), Space: O(V + E)
 */
public class Problem085_CourseSchedule {
    public static void main(String[] args) {
        System.out.println("Running Problem085_CourseSchedule");
        int[][] prerequisites = {{1, 0}}; // Course 1 requires course 0
        System.out.println(canFinish(2, prerequisites)); // Output: true
    }

    /**
     * Check if all courses can be completed (no circular dependencies).
     * 
     * @param numCourses total number of courses
     * @param prerequisites array of [course, prerequisite] pairs
     * @return true if all courses can be finished, false if circular dependency
     */
static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list: course -> list of courses that depend on it
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Track in-degree (number of prerequisites) for each course
        int[] indegree = new int[numCourses];
        
        // Build graph and calculate in-degrees
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }
        
        // Queue for courses with no prerequisites (ready to take)
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Process courses with 0 prerequisites using topological sort
        int visited = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited++;
            
            // For each course that depends on current course
            for (int next : graph.get(course)) {
                indegree[next]--;
                // If no more prerequisites, add to queue
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        // If all courses were processed, no cycle exists
        return visited == numCourses;
    }
}
