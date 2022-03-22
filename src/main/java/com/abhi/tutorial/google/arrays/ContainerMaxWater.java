package com.abhi.tutorial.google.arrays;

// https://leetcode.com/explore/interview/card/google/59/array-and-strings/3048/

public class ContainerMaxWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                int lIdx = left + 1;
                while (height[left] > height[lIdx]) {
                    lIdx++;
                }
                left = lIdx;
            } else {
                int rIdx = right - 1;
                while (height[right] > height[rIdx]) {
                    rIdx--;
                }
                right = rIdx;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {2,3,4,5,18,17,6};
        System.out.println((new ContainerMaxWater()).maxArea(heights));
    }
}
