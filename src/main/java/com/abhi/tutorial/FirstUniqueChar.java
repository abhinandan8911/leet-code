package com.abhi.tutorial;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        int index = -1;
        char[] input = s.toCharArray();
        Set<Character> notUniq = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            if (notUniq.contains(input[i])) {
                continue;
            }
            boolean isUnique = true;
            for (int j = i+1 ; j < input.length; j++) {
                if (input[i] == input[j]) {
                    isUnique = false;
                    notUniq.add(input[i]);
                    break;
                }
            }
            if (isUnique) {
                if (index >= 0) {
                    index = Math.min(index, i);
                }
                if (index == -1) {
                    index = i;
                }
            }
        }
        return index;
    }
}
