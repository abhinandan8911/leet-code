package com.abhi.tutorial.bloomberg;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= nums.length - k ; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k && j < nums.length; j++) {
                max = Math.max(max, nums[j]);
            }
            result.add(max);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
