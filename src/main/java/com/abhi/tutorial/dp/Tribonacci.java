package com.abhi.tutorial.dp;

// https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4041/

import java.util.HashMap;
import java.util.Map;

public class Tribonacci {

    Map<Integer, Integer> cache = new HashMap<>();

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n ==1 || n == 2) {
            return 1;
        }

        if (!cache.containsKey(n)) {
            cache.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        }

        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println((new Tribonacci()).tribonacci(25));
    }
}
