package com.abhi.tutorial.google.heaps;

// https://leetcode.com/problems/find-median-from-data-stream/

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    Queue<Integer> small;
    Queue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        int left = small.peek();
        int right = large.peek();
        return (double) (left + right) / 2;
    }
}
