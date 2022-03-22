package com.abhi.tutorial.google.arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/explore/interview/card/google/59/array-and-strings/3054/

public class LongestSubstringWithTwo {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = 0;
        Set<Character> distinct =  new HashSet<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            distinct.add(arr[i]);
            int len = 1;
            for (int j = i + 1; j < s.length() && distinct.size() <= 2; j++) {
                distinct.add(arr[j]);
                if (distinct.size() <= 2) {
                    len++;
                }
            }
            maxLen = Math.max(maxLen, len);
            distinct.clear();
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println((new LongestSubstringWithTwo()).lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
