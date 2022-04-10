package com.abhi.tutorial.google.sliding;


// https://leetcode.com/problems/permutation-in-string/

import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        String sortedS1 = sortedString(s1.toCharArray());
        int len = sortedS1.length();
        int left = 0;
        int right = left + len;
        while (right <= s2.length()) {
            String s = s2.substring(left, right);
            if (sortedString(s.toCharArray()).equals(sortedS1)) {
                return true;
            } else {
                left++;
                right++;
            }
        }
        return false;
    }

    private String sortedString(char[] chars) {
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println((new PermutationInString()).checkInclusion("adc", "dcda"));
    }
}
