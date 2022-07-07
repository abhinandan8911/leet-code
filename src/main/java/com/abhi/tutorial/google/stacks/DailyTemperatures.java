package com.abhi.tutorial.google.stacks;

// https://leetcode.com/problems/daily-temperatures/

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Arrays.fill(result, 0);
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[1] < temp) {
                int[] pop = stack.pop();
                result[pop[0]] = i - pop[0];
            }
            stack.push(new int[]{i, temp});
        }
        return result;
    }
}
