package com.example.interview_questions;

import java.util.*;

/**
 * Interview Question 059: Sort Players by Score and Name
 *
 * Sort player objects by score (descending) and then by name (ascending).
 *
 * Problem Statement:
 * Given a list of players with name and score, sort them first by score (highest first),
 * and for players with the same score, sort by name alphabetically.
 *
 * Example:
 * Input: Players = [(Alice, 85), (Bob, 85), (Charlie, 75), (Dave, 90)]
 * Output: [(Dave, 90), (Alice, 85), (Bob, 85), (Charlie, 75)]
 * Explanation: Dave has highest score, Alice and Bob have same score (85) but Alice comes first alphabetically
 *
 * Algorithm:
 * - Create Player class with name and score
 * - Use Comparator.thenComparing() for multi-level sorting
 * - First sort by score (descending), then by name (ascending)
 * - Time Complexity: O(n log n)
 * - Space Complexity: O(1)
 */
public class InterviewQuestion059_SortPlayersByScoreAndName {
    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "(" + name + ", " + score + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Sort Players by Score and Name ===\n");

        // Test Case 1
        List<Player> players1 = new ArrayList<>();
        players1.add(new Player("Alice", 85));
        players1.add(new Player("Bob", 85));
        players1.add(new Player("Charlie", 75));
        players1.add(new Player("Dave", 90));

        System.out.println("Input: " + players1);
        List<Player> sorted1 = sortPlayers(new ArrayList<>(players1));
        System.out.println("Output: " + sorted1);
        System.out.println("Expected: [(Dave, 90), (Alice, 85), (Bob, 85), (Charlie, 75)]\n");

        // Test Case 2
        List<Player> players2 = new ArrayList<>();
        players2.add(new Player("Zoe", 100));
        players2.add(new Player("Alice", 100));
        players2.add(new Player("Mike", 100));

        System.out.println("Input: " + players2);
        List<Player> sorted2 = sortPlayers(new ArrayList<>(players2));
        System.out.println("Output: " + sorted2);
        System.out.println("Expected: [(Alice, 100), (Mike, 100), (Zoe, 100)]\n");

        // Test Case 3
        List<Player> players3 = new ArrayList<>();
        players3.add(new Player("Jack", 50));
        players3.add(new Player("Alice", 100));
        players3.add(new Player("Bob", 75));

        System.out.println("Input: " + players3);
        List<Player> sorted3 = sortPlayers(new ArrayList<>(players3));
        System.out.println("Output: " + sorted3);
        System.out.println("Expected: [(Alice, 100), (Bob, 75), (Jack, 50)]\n");

        // Detailed Example
        System.out.println("=== Detailed Breakdown ===");
        sortPlayersDetailed(new ArrayList<>(players1));
    }

    static List<Player> sortPlayers(List<Player> players) {
        players.sort(
            Comparator.comparingInt((Player p) -> p.score).reversed()
                      .thenComparing(p -> p.name)
        );
        return players;
    }

    static void sortPlayersDetailed(List<Player> players) {
        System.out.println("Original: " + players);

        System.out.println("\nSorting by:");
        System.out.println("  1. Score (descending)");
        System.out.println("  2. Name (ascending) - for ties");

        players.sort(
            Comparator.comparingInt((Player p) -> p.score).reversed()
                      .thenComparing(p -> p.name)
        );

        System.out.println("\nSorted: " + players);
    }
}
