package com.abhi.tutorial.dp;


// https://leetcode.com/explore/featured/card/dynamic-programming/631/strategy-for-solving-dp-problems/4148/

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    Map<Integer, Integer> cache = new HashMap<>();

    public int rob(int[] nums) {
        return robValueAt(nums, nums.length - 1);
    }

    private int robValueAt(int[] nums, int pos) {
        if (pos == 0) {
            return nums[0];
        }
        if (pos == 1) {
            return Math.max(nums[0], nums[1]);
        }
        cache.put(pos, Math.max(nums[pos] + robValueAt(nums, pos - 2), robValueAt(nums, pos - 1)));
        return cache.get(pos);
    }

    public static void main(String[] args) {
        int[] input = {2,7,9,3,1};
        System.out.println((new HouseRobber()).rob(input));
    }
}
