package com.abhi.tutorial.google.arrays;

import java.util.Arrays;
import java.util.Collections;


// https://leetcode.com/explore/interview/card/google/59/array-and-strings/361/

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
//        int[] sorted = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] input = {3,2,1,5,6,4};
        System.out.println((new KthLargest()).findKthLargest(input, 2));
    }
}
