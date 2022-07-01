package com.abhi.tutorial.google.arrays;

import java.util.*;
import java.util.stream.Collectors;


// https://leetcode.com/explore/interview/card/google/59/array-and-strings/3049/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len - 1; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int first = nums[i];
            int target = -first;
            int lo = i + 1;
            int hi = len - 1;
            while(lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> val = Arrays.asList(first, nums[lo], nums[hi]);
                    result.add(val);
                    lo++;
                    while(nums[lo] == nums[lo - 1] && lo < hi) {
                        lo++;
                    }
                } else if (target > nums[lo] + nums[hi]) {
                    lo++;
                } else {
                    hi--;
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
