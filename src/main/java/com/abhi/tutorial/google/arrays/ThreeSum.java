package com.abhi.tutorial.google.arrays;

import java.util.*;
import java.util.stream.Collectors;


// https://leetcode.com/explore/interview/card/google/59/array-and-strings/3049/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> counted = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] + first == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        list.sort(Integer::compareTo);
                        if (!counted.contains(list)) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            counted.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = (new ThreeSum()).threeSum(nums);
        result.forEach(lst -> {
            System.out.println(lst.stream().map(String::valueOf).collect(Collectors.joining(" , ")));
        });
    }
}
