package com.abhi.tutorial.bloomberg;

import java.util.Arrays;

public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        Arrays.fill(temp, 0);
        for (int i = 0, j = 0; i < temp.length && j < nums.length; j++) {
            if (nums[j] != 0) {
                temp[i] = nums[j];
                i++;
            }
        }
        nums = temp;
        return nums;
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,3,12};
        int[] result = moveZeroes(input);
        for (int j : result) {
            System.out.println(j);
        }
    }
}
