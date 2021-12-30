package com.abhi.tutorial.bloomberg;

import java.util.Arrays;

public class MedianSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);
        int mid = (merged.length - 1) / 2;
        if (merged.length % 2 == 0) {
            return (merged[mid] + merged[mid + 1])/ (double) 2;
        }
        else {
            return merged[mid];
        }
    }

    public static void main(String[] args) {
        int[] first = {1,2};
        int[] second = {3,4};
        System.out.println(findMedianSortedArrays(first, second));
    }
}
