package com.example.dsa;

/**
 * Problem 011: Container With Most Water
 *
 * Given heights of vertical lines, find two lines that together with the x-axis form a container with maximum water.
 *
 * Approach: Two Pointers from Ends
 * - Start with widest container (both ends)
 * - Move inward, always moving the pointer with smaller height
 * - This greedy approach works: moving the taller one can't improve area
 * - Time: O(n), Space: O(1)
 */
public class Problem011_ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Running Problem011_ContainerWithMostWater");
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(heights)); // Output: 49
    }

    /**
     * Find maximum area between two vertical lines.
     * Area = width × min(height[left], height[right])
     * 
     * @param height array of line heights
     * @return maximum water area that can be contained
     */
static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        
        while (left < right) {
            // Calculate area: width × minimum height
            int area = Math.min(height[left], height[right]) * (right - left);
            
            // Track maximum area seen
            max = Math.max(max, area);
            
            // Greedy: move pointer with smaller height inward
            // Moving taller one can't improve area since limited by minimum
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
}
