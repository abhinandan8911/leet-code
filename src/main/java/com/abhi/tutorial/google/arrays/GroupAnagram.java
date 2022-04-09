package com.abhi.tutorial.google.arrays;

// https://leetcode.com/problems/group-anagrams/

import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length && visited.size() < strs.length; i++) {
            String first = strs[i];
            if (!visited.contains(first)) {
                List<String> list = new ArrayList<>();
                list.add(first);
                visited.add(first);
                for (int j = i + 1; j < strs.length; j++) {
                    String next = strs[j];
                    if (!visited.contains(next) && isAnagram(first, next)) {
                        visited.add(next);
                        list.add(next);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length() || (a.length() == 0 && b.length() == 0)) {
            return false;
        }
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        Arrays.sort(achars);
        Arrays.sort(bchars);
        return Arrays.equals(achars, bchars);
    }
}
