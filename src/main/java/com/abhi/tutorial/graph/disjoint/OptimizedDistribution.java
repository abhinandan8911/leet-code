package com.abhi.tutorial.graph.disjoint;

// https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3916/

import java.util.Arrays;
import java.util.Comparator;

public class OptimizedDistribution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind unionFind = new UnionFind(n + 1);
        int[][] updatedPipes = new int[pipes.length + n][];
        for(int i = 0; i < wells.length; i++) {
            int[] val = {0, i + 1, wells[i]};
            updatedPipes[i] = val;
        }
        for(int[] pipe : pipes) {
            updatedPipes[n++] = pipe;
        }
        Arrays.sort(updatedPipes, Comparator.comparingInt(p -> p[2]));
        int cost = 0;
        for(int[] updatedPipe : updatedPipes) {
            if (unionFind.union(updatedPipe[0], updatedPipe[1])) {
                cost = cost + updatedPipe[2];
            }
        }
        return cost;
    }

    public static class UnionFind {
        int[] root;
        int[] rank;
        int count;
        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            count = n;
            for(int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        OptimizedDistribution optimizedDistribution = new OptimizedDistribution();
        int[] wells = {46012,72474,64965,751,33304};
        int[][] pipes = {{2,1,6719}, {3,2,75312}, {5,3,44918}};
        System.out.println(optimizedDistribution.minCostToSupplyWater(5, wells, pipes));
    }
}
