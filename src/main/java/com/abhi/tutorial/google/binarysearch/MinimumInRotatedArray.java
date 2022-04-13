package com.abhi.tutorial.google.binarysearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/

public class MinimumInRotatedArray {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if (nums[lo] <= nums[mid]) {
                if (nums[hi] >= nums[mid]) {
                    return nums[lo];
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
