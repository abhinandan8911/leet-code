package com.abhi.tutorial.google.arrays;

// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSeq {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;
        for(int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while(set.contains(num + 1)) {
                    num = num + 1;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
