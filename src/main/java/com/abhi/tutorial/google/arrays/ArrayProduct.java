package com.abhi.tutorial.google.arrays;

// https://leetcode.com/problems/product-of-array-except-self/

public class ArrayProduct {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int pref = 1;
        for(int i = 0; i < len; i++) {
            prefix[i] = pref;
            pref = pref * nums[i];
        }
        int suff = 1;
        for(int i = len - 1; i >= 0; i--) {
            suffix[i] = suff;
            suff = suff * nums[i];
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}
