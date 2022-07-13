package com.abhi.tutorial.graph;

// https://leetcode.com/problems/max-area-of-island/

public class MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int area = 1;
        for(int[] dir : dirs) {
            area += dfs(grid, row + dir[0], col + dir[1]);
        }
        return area;
    }
}
