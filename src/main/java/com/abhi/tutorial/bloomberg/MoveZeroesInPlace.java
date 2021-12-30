package com.abhi.tutorial.bloomberg;

public class MoveZeroesInPlace {
    public static int[] moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int next = i + 1;
                while(next < nums.length && nums[next] == 0) {
                    next++;
                }
                if (next < nums.length) {
                    nums[i] = nums[next];
                    nums[next] = 0;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] ints = {0,0,1};
        int[] result = moveZeroes(ints);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
