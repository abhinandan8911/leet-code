package com.abhi.tutorial.graph;

// https://leetcode.com/explore/featured/card/graph/620/breadth-first-search-in-graph/3894/

import java.util.*;

public class BFSFindPathExists {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return true;
            }
            for (int adjNode : adjList.get(node)) {
                if (!visited.contains(adjNode)) {
                    visited.add(adjNode);
                    queue.add(adjNode);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        System.out.println((new BFSFindPathExists()).validPath(3, edges, 0, 2));
    }
}
