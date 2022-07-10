package com.abhi.tutorial.google.sliding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/minimum-window-substring/submissions/

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int[] result = {Integer.MAX_VALUE,0,0};

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        int targetNum = target.values().stream().mapToInt(Integer::intValue).sum();
        Set<Character> keys = target.keySet();
        int left = 0;
        int right = 0;
        int windowNum = 0;
        while(right < s.length()) {
            char ch = s.charAt(right);
            if (keys.contains(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch) <= target.get(ch)) {
                    windowNum++;
                }
            }
            if (windowNum == targetNum) {
                if (result[0] >= (right - left)) {
                    result = new int[]{right - left, left, right};
                }

                while(left < right && (windowNum == targetNum)) {
                    char l = s.charAt(left++);
                    if (keys.contains(l)) {
                        window.put(l, window.get(l) - 1);
                        if (window.get(l) < target.get(l)) {
                            windowNum--;
                        }
                    }
                    if (windowNum == targetNum) {
                        if (result[0] >= (right - left)) {
                            result = new int[]{right - left, left, right};
                        }
                    }
                }
            }
            right++;
        }
        if (result[0] == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(result[1], result[2] + 1);
    }
}
