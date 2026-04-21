package com.example.interview_questions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Interview Question 016: First Non-Repeating Number in List
 *
 * Given a list of integers, find the first non-repeating number.
 *
 * Example:
 * Input: [1, 2, 3, 2, 1, 4]
 * Output: 3
 *
 * Explanation: Use LinkedHashMap to preserve order and count frequencies.
 */
public class InterviewQuestion016_FirstNonRepeatingNumberInList {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion016_FirstNonRepeatingNumberInList");
        List<Integer> nums = List.of(1, 2, 3, 2, 1, 4);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        System.out.println(result); // Output: 3
    }
}