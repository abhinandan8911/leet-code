package com.abhi.tutorial.scratch;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/

public class SubSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            getSubsets(0, nums, new ArrayList<>(), result, i);
        }
        return result;
    }

    private void getSubsets(int index, int[] nums, List<Integer> subSet, List<List<Integer>> set, int size) {
        if (subSet.size() == size) {
            set.add(new ArrayList<>(subSet));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            subSet.add(nums[i]);
            getSubsets(i + 1, nums, subSet, set, size);
            subSet.remove(subSet.size() - 1);
        }
    }
}
