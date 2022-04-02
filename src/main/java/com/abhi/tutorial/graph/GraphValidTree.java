package com.abhi.tutorial.graph;

import java.util.*;

// https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3910/

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int adjNode : adjList.get(node)) {
                if (!visited.contains(adjNode)) {
                    visited.add(adjNode);
                    queue.add(adjNode);
                }
            }
        }
        return visited.size() == n;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
//        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println((new GraphValidTree()).validTree(5, edges));
    }
}
