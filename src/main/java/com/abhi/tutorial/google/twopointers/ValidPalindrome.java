package com.abhi.tutorial.google.twopointers;

// https://leetcode.com/problems/valid-palindrome/

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String conv = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().trim();
        int lo = 0;
        int hi = conv.length() - 1;
        while (lo < hi) {
            if (conv.charAt(lo) == conv.charAt(hi)) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }
}
