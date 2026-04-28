package com.example.interview_questions;

import java.util.Arrays;

/**
 * Interview Question 049: Candy Distribution (LeetCode 135)
 *
 * There are n children standing in a line. Each child is assigned a rating value given in the array ratings.
 * You are giving candies to these children such that:
 * - Each child must receive at least one candy.
 * - Children with a higher rating than their neighbors get more candies than those neighbors.
 *
 * Return the minimum number of candies you need to distribute.
 *
 * Example 1:
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 *
 * Example 2:
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 *
 * Example 3:
 * Input: ratings = [1,3,2,2,1]
 * Output: 7
 *
 * Constraints:
 * - n == ratings.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= ratings[i] <= 10^5
 *
 * Approach: Two-Pass Greedy Algorithm
 * - First pass (left to right): ensure each child with higher rating than left neighbor gets more candies
 * - Second pass (right to left): ensure each child with higher rating than right neighbor gets more candies
 * - Time: O(n), Space: O(n)
 */
public class InterviewQuestion049_CandyDistribution {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion049_CandyDistribution");
        
        int[] ratings1 = {1, 0, 2};
        System.out.println("Input: " + Arrays.toString(ratings1)); //6
        System.out.println("Distribution: " + Arrays.toString(calculateDistribution(ratings1)));
        
        int[] ratings2 = {1, 2, 2};
        System.out.println("\nInput: " + Arrays.toString(ratings2)); //4
        System.out.println("Distribution: " + Arrays.toString(calculateDistribution(ratings2)));
        
        int[] ratings3 = {1, 3, 2, 2, 1};
        System.out.println("\nInput: " + Arrays.toString(ratings3)); //7
        System.out.println("Distribution: " + Arrays.toString(calculateDistribution(ratings3)));
    }



    /**
     * Helper method to get the actual candy distribution (for visualization).
     */
    static Object[] calculateDistribution(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        // Calculate total candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        
        return new Object[]{total, Arrays.toString(candies)};
    }
}
