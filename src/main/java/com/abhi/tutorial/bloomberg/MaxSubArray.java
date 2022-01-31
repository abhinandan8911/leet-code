package com.abhi.tutorial.bloomberg;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = 0;
            for (int j = i; j < nums.length; j++) {
                current = current + nums[j];
                maxSum = Integer.max(maxSum, current);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] ints = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(ints));
    }
}
