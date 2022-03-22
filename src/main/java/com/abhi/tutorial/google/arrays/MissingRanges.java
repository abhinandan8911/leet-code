package com.abhi.tutorial.google.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/interview/card/google/59/array-and-strings/3055/

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            if (lower != upper) {
                result.add(lower + "->" + upper);
            } else {
                result.add(String.valueOf(lower));
            }
        } else {
            if (nums[0] > lower) {
                if (nums[0] - lower > 1) {
                    result.add(lower + "->" + (nums[0] - 1));
                } else {
                    result.add(String.valueOf(lower));
                }
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i-1] > 2) {
                    result.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
                }
                if (nums[i] - nums[i-1] == 2) {
                    result.add(String.valueOf(nums[i] - 1));
                }
            }
            if (nums[nums.length - 1] < upper) {
                if (upper - nums[nums.length - 1] > 1) {
                    result.add((nums[nums.length - 1] + 1) + "->" + upper);
                } else {
                    result.add(String.valueOf(upper));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        List<String> result = (new MissingRanges()).findMissingRanges(nums, 0, 99);
        result.forEach(System.out::println);
    }
}
