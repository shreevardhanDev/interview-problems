package com.example.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem 104: Meeting Rooms II
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: [[0,30],[5,10],[15,20]]
 * Output: 2
 * Explanation: We need two rooms because the meetings [0,30] and [5,10] overlap, and [15,20] can use one of the rooms after [5,10] ends.
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 * Explanation: Only one room is needed since the meetings do not overlap.
 *
 * Constraints:
 * - 1 <= intervals.length <= 10^4
 * - 0 <= si < ei <= 10^6
 *
 * Approach: Priority Queue (Min Heap)
 * - Sort intervals by start time
 * - Use a min heap to track end times of meetings
 * - For each meeting, if it starts after the earliest end time, reuse the room
 * - Time: O(n log n), Space: O(n)
 */
public class Problem104_MeetingRoomsII {
    public static void main(String[] args) {
        System.out.println("Running Problem104_MeetingRoomsII");
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int result = minMeetingRooms(intervals);
        System.out.println(result); // Output: 2
    }

    /**
     * Find the minimum number of meeting rooms required.
     *
     * @param intervals the array of meeting intervals
     * @return the minimum number of rooms
     */
    static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Min heap for end times
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        endTimes.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If current meeting starts after the earliest end time, reuse the room
            if (intervals[i][0] >= endTimes.peek()) {
                endTimes.poll();
            }
            // Add the current meeting's end time
            endTimes.add(intervals[i][1]);
        }

        return endTimes.size();
    }
}