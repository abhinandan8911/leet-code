package com.abhi.tutorial.bloomberg;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int expecting = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == expecting) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {3, 3};
        int[] result = twoSum(input, 6);
        for (int e : result) {
            System.out.println(e);
        }
    }
}
