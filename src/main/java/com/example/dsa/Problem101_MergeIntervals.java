package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem 101: Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * - 1 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= starti <= endi <= 10^4
 *
 * Approach: Sorting
 * - Sort the intervals by their start time
 * - Iterate through the sorted intervals and merge overlapping ones
 * - Time: O(n log n) due to sorting, Space: O(n)
 */
public class Problem101_MergeIntervals {
    public static void main(String[] args) {
        System.out.println("Running Problem101_MergeIntervals");
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        System.out.println(Arrays.deepToString(result)); // Output: [[1,6],[8,10],[15,18]]
    }

    /**
     * Merge overlapping intervals.
     *
     * @param intervals the input array of intervals
     * @return the merged intervals
     */
    static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                // Overlap, merge
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap, add current to result
                merged.add(current);
                current = intervals[i];
            }
        }
        // Add the last interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);
    }
}