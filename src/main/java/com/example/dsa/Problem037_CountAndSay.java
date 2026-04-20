package com.example.dsa;

/**
 * Problem 037: Count and Say
 *
 * Generate the nth term of the count-and-say sequence.
 *
 * Solution explanation in code comments.
 */
public class Problem037_CountAndSay {
    public static void main(String[] args) {
        System.out.println("Running Problem037_CountAndSay");
        System.out.println("Example is in method comments.");
    }

    // Core solution method
static String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prev) {
                    count++;
                } else {
                    next.append(count).append(prev);
                    prev = result.charAt(j);
                    count = 1;
                }
            }
            next.append(count).append(prev);
            result = next.toString();
        }
        return result;
    }
}
