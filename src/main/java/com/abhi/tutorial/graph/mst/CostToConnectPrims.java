package com.abhi.tutorial.graph.mst;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/min-cost-to-connect-all-points/
public class CostToConnectPrims {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.weight, p2.weight));
        Pair start = new Pair(0,0);
        Set<Integer> visited = new HashSet<>();
        pq.add(start);
        int edges = 0;
        int totalWeight = 0;
        while(!pq.isEmpty() && edges < n) {
            Pair current = pq.poll();
            if(visited.contains(current.index)) {
                continue;
            }
            visited.add(current.index);
            edges++;
            totalWeight = totalWeight + current.weight;
            for(int i = 0; i < n; i++) {
                int[] vertex = points[current.index];
                int[] point = points[i];
                int weight = Math.abs(vertex[0] - point[0]) + Math.abs(vertex[1] - point[1]);
                pq.add(new Pair(weight, i));
            }
        }
        return totalWeight;
    }

    public static class Pair {
        public final Integer weight;
        public final Integer index;
        Pair(Integer weight, Integer index) {
            this.weight = weight;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[][] points = {{2,-3},{-17,-8},{13,8},{-17,-15}};
        CostToConnectPrims connectPrims = new CostToConnectPrims();
        System.out.println(connectPrims.minCostConnectPoints(points));
    }
}
