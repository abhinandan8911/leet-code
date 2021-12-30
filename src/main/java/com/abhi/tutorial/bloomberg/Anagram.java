package com.abhi.tutorial.bloomberg;

import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        char[] first = s.toCharArray();
        Arrays.sort(first);
        char[] second = t.toCharArray();
        Arrays.sort(second);
        s = String.valueOf(first);
        t = String.valueOf(second);
        return s.equals(t);
    }
}
