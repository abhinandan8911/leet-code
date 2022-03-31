package com.abhi.tutorial.dp;


// https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4147/

import java.util.HashMap;
import java.util.Map;

public class DeleteEarn {

    Map<Integer, Integer> numMap = new HashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }

        return calculate(nums, maxNum);
    }

    private int calculate(int[] nums, int maxNum) {
        if (maxNum == 0) {
            return 0;
        }

        if (maxNum == 1) {
            return numMap.getOrDefault(1, 0);
        }

        if (!cache.containsKey(maxNum)) {
            int value = numMap.getOrDefault(maxNum, 0);
            cache.put(maxNum, Math.max(value + calculate(nums, maxNum - 2), calculate(nums, maxNum - 1)));
        }
        return cache.get(maxNum);
    }

    public static void main(String[] args) {
        int[] input = {2,2,3,3,3,4};
        System.out.println((new DeleteEarn()).deleteAndEarn(input));
    }
}
