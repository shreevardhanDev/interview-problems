package com.example.dsa;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem 103: Meeting Rooms
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * Example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Explanation: The person cannot attend the meeting from 5 to 10 because they are already in a meeting from 0 to 30.
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: true
 * Explanation: Since the intervals [7,10] and [2,4] do not overlap, the person can attend both meetings.
 *
 * Constraints:
 * - 0 <= intervals.length <= 10^4
 * - 0 <= si < ei <= 10^6
 *
 * Approach: Sorting
 * - Sort the intervals by start time
 * - Check if any two consecutive intervals overlap
 * - Time: O(n log n), Space: O(1) if sorting in place
 */
public class Problem103_MeetingRooms {
    public static void main(String[] args) {
        System.out.println("Running Problem103_MeetingRooms");
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        boolean result = canAttendMeetings(intervals);
        System.out.println(result); // Output: false
    }

    /**
     * Check if a person can attend all meetings without conflicts.
     *
     * @param intervals the array of meeting intervals
     * @return true if no conflicts, false otherwise
     */
    static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) return true;

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // Overlap
            }
        }
        return true;
    }
}