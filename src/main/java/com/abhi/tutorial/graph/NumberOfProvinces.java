package com.abhi.tutorial.graph;

import java.util.HashSet;
import java.util.Set;


// https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3845/

public class NumberOfProvinces {

    int[] set;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        set = new int[n];
        // init disjoint set
        for (int i = 0; i < n; i++) {
            set[i] = i;
        }

        for (int i = 0; i < n; i++) {
            // since it is square
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    join(i, j);
                }
            }
        }

        Set<Integer> uniqProvince = new HashSet<>();
        for (int num : set) {
            uniqProvince.add(num);
        }
        return uniqProvince.size();
    }

    private int find(int x) {
        return set[x];
    }

    private void join(int i, int j) {
        int iX = find(i);
        int jX = find(j);
        if (iX != jX) {
            for (int k = 0; k < set.length; k++) {
                if (set[k] == jX) {
                    set[k] = iX;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}};
        System.out.println((new NumberOfProvinces()).findCircleNum(matrix));
    }
}
