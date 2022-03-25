package com.abhi.tutorial.graph;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (n > 1 && edges.length == 0) {
            return false;
        }
        int[] set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if (set[child] == child) {
                set[child] = parent;
            } else {
                return false;
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (set[i] == i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        System.out.println((new GraphValidTree()).validTree(5, edges));
    }
}
