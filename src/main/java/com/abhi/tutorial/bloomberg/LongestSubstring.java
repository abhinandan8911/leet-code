package com.abhi.tutorial.bloomberg;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] in = s.toCharArray();
        int maxLen = 0;
        for (int i = 0; i < in.length; i++) {
            Set<Character> characters = new HashSet<>();
            characters.add(in[i]);
            for (int j = i + 1; j < in.length; j++) {
                if (!characters.contains(in[j])) {
                    characters.add(in[j]);
                }
                else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, characters.size());
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
