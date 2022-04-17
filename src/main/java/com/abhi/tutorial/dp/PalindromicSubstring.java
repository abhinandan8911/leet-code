package com.abhi.tutorial.dp;

// https://leetcode.com/problems/palindromic-substrings/

public class PalindromicSubstring {

    public int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l = l - 1;
                r = r + 1;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l = l - 1;
                r = r + 1;
            }

        }

        return count;

    }
}
