package com.example.dsa;

/**
 * Problem 084: Number of Islands
 *
 * Count islands of 1s in a grid using DFS or BFS.
 *
 * Approach: Depth-First Search (DFS) Flood Fill
 * - Iterate through grid, counting islands
 * - When '1' found, perform DFS to mark all connected '1's as visited
 * - Convert visited cells from '1' to '0' to avoid recounting
 * - Time: O(m * n), Space: O(m * n) for recursion stack
 */
public class Problem084_NumberOfIslands {
    public static void main(String[] args) {
        System.out.println("Running Problem084_NumberOfIslands");
        
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid)); // Output: 3
    }

    /**
     * Count the number of islands in a grid.
     * Island = group of 1s connected horizontally or vertically.
     * 
     * @param grid the 2D grid of '0' and '1'
     * @return number of islands
     */
static int numIslands(char[][] grid) {
        int count = 0;
        
        // Scan each cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // When island starting point found
                if (grid[i][j] == '1') {
                    count++;
                    // Mark entire island as visited using DFS flood fill
                    floodFill(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    /**
     * DFS flood fill to mark all connected '1's as '0' (visited).
     * 
     * @param grid the grid to mark
     * @param i row coordinate
     * @param j column coordinate
     */
    private static void floodFill(char[][] grid, int i, int j) {
        // Boundary check or already visited
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        
        // Mark as visited by converting to '0'
        grid[i][j] = '0';
        
        // Recursively visit all four adjacent cells
        floodFill(grid, i + 1, j); // Down
        floodFill(grid, i - 1, j); // Up
        floodFill(grid, i, j + 1); // Right
        floodFill(grid, i, j - 1); // Left
    }
}
