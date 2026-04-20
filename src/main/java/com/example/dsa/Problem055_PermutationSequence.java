package com.example.dsa;

/**
 * Problem 055: Permutation Sequence
 *
 * Return the kth permutation sequence of numbers 1..n.
 *
 * Solution explanation in code comments.
 */
public class Problem055_PermutationSequence {
    public static void main(String[] args) {
        System.out.println("Running Problem055_PermutationSequence");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static String getPermutation(int n, int k) {
        java.util.List<Integer> numbers = new java.util.ArrayList<>();
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        k--;
        StringBuilder result = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            factorial /= i;
            int index = k / factorial;
            result.append(numbers.remove(index));
            k %= factorial;
        }
        return result.toString();
    }
}
