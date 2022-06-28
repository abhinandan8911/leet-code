package com.abhi.tutorial.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3857/

public class CostToConnectKrushkal {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int[] src = points[i];
            for(int j = i + 1; j < n ; j++) {
                int[] dest = points[j];
                int dist = Math.abs(src[0] - dest[0]) + Math.abs(src[1] - dest[1]);
                int[] value = {dist, i, j};
                adjList.add(value);
            }
        }
        Collections.sort(adjList, (a, b) -> Integer.compare(a[0], b[0]));
        int cost = 0;
        UnionFind unionFind = new UnionFind(n);
        for(int i = 0; i < adjList.size() && !unionFind.isDone(); i++) {
            if (unionFind.union(adjList.get(i)[1], adjList.get(i)[2])) {
                cost = cost + adjList.get(i)[0];
            }
        }

        return cost;
    }

    public static class UnionFind {
        int[] root;
        int[] rank;
        int edge;
        UnionFind(int n) {
            root = new int[n];
            rank = new int[n];
            edge = 0;
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
            if(rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                edge++;
                return true;
            }
            return false;
        }

        public boolean isDone() {
            return edge == root.length - 1;
        }
    }

    public static void main(String[] args) {
        int[][] points = {{2,-3},{-17,-8},{13,8},{-17,-15}};
        CostToConnectKrushkal cost = new CostToConnectKrushkal();
        System.out.println(cost.minCostConnectPoints(points));
    }
}
