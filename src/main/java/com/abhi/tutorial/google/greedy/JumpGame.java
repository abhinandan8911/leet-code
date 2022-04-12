package com.abhi.tutorial.google.greedy;

// https://leetcode.com/problems/jump-game/

public class JumpGame {

    public boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int target = nums.length - 1;
        int last = target - 1;
        while(target > 0 && last >= 0) {
            if (nums[last] >= target - last) {
                if (last == 0) {
                    return true;
                }
                target = last;
                last = target - 1;
            } else {
                last--;
            }
        }
        return false;
    }
}
