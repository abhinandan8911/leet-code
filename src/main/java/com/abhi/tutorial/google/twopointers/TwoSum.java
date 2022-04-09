package com.abhi.tutorial.google.twopointers;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] == target) {
                break;
            } else if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return new int[]{lo+1, hi+1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString((new TwoSum()).twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
