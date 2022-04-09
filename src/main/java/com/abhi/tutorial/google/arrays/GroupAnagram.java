package com.abhi.tutorial.google.arrays;

// https://leetcode.com/problems/group-anagrams/

import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ans = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            ans.computeIfAbsent(String.valueOf(chars), s -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(ans.values());
    }
}
