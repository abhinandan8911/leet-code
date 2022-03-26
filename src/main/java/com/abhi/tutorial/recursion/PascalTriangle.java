package com.abhi.tutorial.recursion;


// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(getValue(rowIndex, i));
        }
        return result;
    }

    private int getValue(int row, int col) {
        String key = String.valueOf(row) + col;
        Map<String, Integer> cache = new HashMap<>();
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (row == 0 || col == 0 || row == col) {
            return 1;
        } else {
            int val = getValue(row - 1, col - 1) + getValue(row - 1, col);
            cache.put(key, val);
            return val;
        }
    }
}
