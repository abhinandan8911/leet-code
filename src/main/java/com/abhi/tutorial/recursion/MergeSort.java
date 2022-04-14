package com.abhi.tutorial.recursion;

import java.util.Arrays;
import java.util.stream.Collectors;


// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/

public class MergeSort {

    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] result = new int[leftLength + rightLength];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < leftLength && resultIndex < result.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < rightLength && resultIndex < result.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {5,2,3,1};
        int[] result = (new MergeSort()).sortArray(input);
        System.out.println(Arrays.toString(result));
    }
}
