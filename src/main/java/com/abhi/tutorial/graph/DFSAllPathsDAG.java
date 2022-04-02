package com.abhi.tutorial.graph;

// https://leetcode.com/explore/featured/card/graph/619/depth-first-search-in-graph/3849/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DFSAllPathsDAG {

    // DFS
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for (int nextNode : nextNodes) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
//        int[][] graph = {{1,2}, {3}, {3}, {}};
        List<List<Integer>> result = (new DFSAllPathsDAG()).allPathsSourceTarget(graph);
        result.forEach(list -> {
            String joinedList = list.stream().map(String::valueOf).collect(Collectors.joining(" , "));
            System.out.println(joinedList);
        });
    }
}
