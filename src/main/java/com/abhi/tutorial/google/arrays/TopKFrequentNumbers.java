package com.abhi.tutorial.google.arrays;

// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentNumbers {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        pq.addAll(map.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(pq.poll()).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(Arrays.stream((new TopKFrequentNumbers()).topKFrequent(nums, 2)).mapToObj(String::valueOf).collect(Collectors.joining( ", ")));
    }

}
