package com.abhi.tutorial.google.sliding;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> slider = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (slider.contains(ch)) {
                slider.remove(s.charAt(left));
                left++;
            }
            slider.add(ch);
            maxLen = Math.max(maxLen, slider.size());
        }
        return maxLen;
    }
}
