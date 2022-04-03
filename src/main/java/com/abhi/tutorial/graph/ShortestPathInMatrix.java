package com.abhi.tutorial.graph;


// https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3896/

import java.util.*;

public class ShortestPathInMatrix {

    static class Pair {
        Integer left;
        Integer right;
        Pair(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return left.equals(pair.left) && right.equals(pair.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        int row = 0, col = 0;
        Pair dest = new Pair(grid.length - 1, grid.length - 1);
        Set<Pair> visited = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(row, col));
        visited.add(new Pair(row, col));
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair coord = queue.poll();
                if (dest.equals(coord)) {
                    return count;
                }
                row = coord.left;
                col = coord.right;
                if ((col - 1 >= 0) && grid[row][col - 1] == 0) {
                    Pair next = new Pair(row, col - 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
                if ((col + 1 < grid.length) && grid[row][col + 1] == 0) {
                    Pair next = new Pair(row, col + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
                if ((row - 1 >= 0) && grid[row - 1][col] == 0) {
                    Pair next = new Pair(row - 1, col);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
                if ((row + 1 < grid.length) && grid[row + 1][col] == 0) {
                    Pair next = new Pair(row + 1, col);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
                if ((row - 1 >= 0) && (col - 1 >= 0) && grid[row - 1][col - 1] == 0) {
                    Pair next = new Pair(row - 1, col - 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
                if ((row - 1 >= 0) && (col + 1 < grid.length) && grid[row - 1][col + 1] == 0) {
                    Pair next = new Pair(row - 1, col + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
                if ((row + 1 < grid.length) && (col + 1 < grid.length) && grid[row + 1][col + 1] == 0) {
                    Pair next = new Pair(row + 1, col + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
                if ((row + 1 < grid.length) && (col - 1 >= 0) && grid[row + 1][col - 1] == 0) {
                    Pair next = new Pair(row + 1, col - 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0,1}, {1,0}};
        int[][] grid = {{1,0,0}, {1,1,0}, {1,1,0}};
        System.out.println((new ShortestPathInMatrix()).shortestPathBinaryMatrix(grid));
    }
}
