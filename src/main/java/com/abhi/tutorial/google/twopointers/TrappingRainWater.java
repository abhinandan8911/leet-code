package com.abhi.tutorial.google.twopointers;

// https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater {

    public int trap(int[] height) {

        if (height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax > height[left]) {
                    result = result + (leftMax - height[left]);
                }
                leftMax = Math.max(leftMax, height[left]);
            } else {
                right--;
                if (rightMax > height[right]) {
                    result = result + (rightMax - height[right]);
                }
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return result;
    }
}
