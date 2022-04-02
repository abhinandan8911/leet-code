package com.abhi.tutorial.graph;

// https://leetcode.com/explore/featured/card/graph/619/depth-first-search-in-graph/3893/

import java.util.*;

public class DFSFindPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> ajcList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            ajcList.add(list);
        }

        for (int[] edge : edges) {
            ajcList.get(edge[0]).add(edge[1]);
            ajcList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == destination) {
                return true;
            }
            if (!visited.contains(node)) {
                visited.add(node);
                for (int adjNode : ajcList.get(node)) {
                    stack.push(adjNode);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,0}};
        System.out.println((new DFSFindPathExists()).validPath(3, edges, 0, 2));
    }
}
