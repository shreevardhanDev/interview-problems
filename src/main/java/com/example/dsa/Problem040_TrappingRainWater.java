package com.example.dsa;

/**
 * Problem 040: Trapping Rain Water
 *
 * Compute how much water is trapped after raining given height map.
 *
 * Solution explanation in code comments.
 */
public class Problem040_TrappingRainWater {
    public static void main(String[] args) {
        System.out.println("Running Problem040_TrappingRainWater");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
