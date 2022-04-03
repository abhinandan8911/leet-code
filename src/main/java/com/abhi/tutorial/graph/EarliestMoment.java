package com.abhi.tutorial.graph;

// https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3912/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EarliestMoment {

    int[] set;
    int earliest = -1;
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (log1, log2) -> {
            Integer tsp1 = log1[0];
            Integer tsp2 = log2[0];
            return tsp1.compareTo(tsp2);
        });
        set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
        }

        for (int[] log : logs) {
            union(log[1], log[2]);
            if (isAllConnected()) {
                return log[0];
            }
        }
        return earliest;
    }

    private int find(int node) {
        return set[node];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            for (int i = 0; i < set.length; i++) {
                if (set[i] == rootY) {
                    set[i] = rootX;
                }
            }
        }
    }

    private boolean isAllConnected() {
        Set<Integer> roots = new HashSet<>();
        for (int root : set) {
            roots.add(root);
        }
        return roots.size() == 1;
    }

    public static void main(String[] args) {
        int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        System.out.println((new EarliestMoment()).earliestAcq(logs, 6));
    }
}
