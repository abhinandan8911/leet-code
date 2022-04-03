package com.abhi.tutorial.graph;

// https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3911/

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponents {

    int[] set;

    public int countComponents(int n, int[][] edges) {
        set = new int[n];

        for (int i = 0; i < n; i++) {
            set[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        Set<Integer> comp = new HashSet<>();
        for (int num : set) {
            comp.add(num);
        }

        return comp.size();
    }

    private int find(int x) {
        return set[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < set.length; i++) {
                if(set[i] == rootY) {
                    set[i] = rootX;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] edges = {{0,1}, {1,2}, {3,4}};
        int[][] edges = {{0,1}, {1,2}, {2,3}, {3,4}};
        System.out.println((new NumberOfConnectedComponents()).countComponents(5, edges));
    }
}
