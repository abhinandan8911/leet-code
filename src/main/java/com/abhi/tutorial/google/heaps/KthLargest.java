package com.abhi.tutorial.google.heaps;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

    Queue<Integer> pq;
    int capacity;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        capacity = k;
        for (int num : nums) {
            pq.offer(num);
        }
        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > capacity) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
