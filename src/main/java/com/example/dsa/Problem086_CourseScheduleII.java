package com.example.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Problem 086: Course Schedule II
 *
 * Return a valid order in which courses can be finished.
 *
 * Solution explanation in code comments.
 */
public class Problem086_CourseScheduleII {
    public static void main(String[] args) {
        System.out.println("Running Problem086_CourseScheduleII");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
    static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) queue.offer(i);
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }
        return index == numCourses ? order : new int[0];
    }
}
