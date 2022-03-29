package com.abhi.tutorial.dp;


// https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4040/

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbing {

    Map<Integer, Integer> cache = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return minCostAtStep(cost, cost.length);
    }

    private int minCostAtStep(int[] cost, int step) {
        if (cost.length == 0) {
            return 0;
        }
        if (step <= 1) {
            return 0;
        }
        if (!cache.containsKey(step)) {
            cache.put(step, Math.min(cost[step - 1] + minCostAtStep(cost, step - 1),
                    cost[step - 2] + minCostAtStep(cost, step - 2)));
        }
        return cache.get(step);
    }

    public static void main(String[] args) {
        int[] input = {1,100,1,1,1,100,1,1,100,1};
        System.out.println((new MinCostClimbing()).minCostClimbingStairs(input));
    }
}
