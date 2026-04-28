package com.example.interview_questions;

/**
 * Interview Question 050: Sum of Digits in String
 *
 * Given a string, calculate the sum of all digit characters in it.
 *
 * Example 1:
 * Input: "aa1bc2d3"
 * Output: 6 (1 + 2 + 3)
 *
 * Example 2:
 * Input: "a1b2c3"
 * Output: 6
 *
 * Example 3:
 * Input: "abcdef"
 * Output: 0
 *
 * Approach: Stream filter and map
 * - Filter characters that are digits
 * - Map each digit to its numeric value
 * - Sum all values
 * - Time: O(n), Space: O(1)
 */
public class InterviewQuestion050_SumOfDigitsInString {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion050_SumOfDigitsInString");
        
        String test1 = "aa1bc2d3";
        int result1 = sumOfDigits(test1);
        System.out.println("Input: \"" + test1 + "\"");
        System.out.println("Output: " + result1); // 6
        
        String test2 = "a1b2c3";
        int result2 = sumOfDigits(test2);
        System.out.println("\nInput: \"" + test2 + "\"");
        System.out.println("Output: " + result2); // 6
        
        String test3 = "abcdef";
        int result3 = sumOfDigits(test3);
        System.out.println("\nInput: \"" + test3 + "\"");
        System.out.println("Output: " + result3); // 0
        
        String test4 = "123abc456";
        int result4 = sumOfDigits(test4);
        System.out.println("\nInput: \"" + test4 + "\"");
        System.out.println("Output: " + result4); // 21 (1+2+3+4+5+6)
    }

    /**
     * Sum all digits in a string using streams.
     *
     * @param s the input string
     * @return sum of all digit characters
     */
    static int sumOfDigits(String s) {
        return s.chars()
            .filter(Character::isDigit)
            .map(Character::getNumericValue)
            .sum();
    }
}
