package com.example.interview_questions;

/**
 * Interview Question 022: Best Time to Buy and Sell Stock (LeetCode 121)
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * <p>
 * Explanation: Buy on day 2, sell on day 5.
 */
public class InterviewQuestion022_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("Running InterviewQuestion022_BestTimeToBuyAndSellStock");
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println(result); // Output: 5
    }

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}