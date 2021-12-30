package com.abhi.tutorial.bloomberg;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqCharacterSecond {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Character nonRepeating = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                nonRepeating = entry.getKey();
                break;
            }
        }
        if (nonRepeating == null) {
            return -1;
        }
        else {
            return s.indexOf(nonRepeating);
        }
    }
}
